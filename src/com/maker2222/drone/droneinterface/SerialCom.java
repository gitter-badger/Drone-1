package com.maker2222.drone.droneinterface;

import java.io.InputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class SerialCom implements SerialPortDataListener, Connection{
	
	private int dataLength;
	private int parity;
	private int stopBits;
	private String port;
	private int baudrate;
	private byte[] buffer;
	private SerialPort serialPort;
	
	/** SerialComm object, represents a connection with Arduino. When conected
	 * Arduino is rebooted.
	 * 
	 * @param port : Port where Arduino is conencted.
	 * 
	 * @param baudrate : Baudrate to connect.
	 * 
	 * @param delay : Time that costs Arduino to reboot.
	 * @param dataLength 
	 */
	
	public SerialCom(String port, int baudrate, int dataLength, int stopBits, int parity, int bufferSize){
		this.port = port;
		this.baudrate = baudrate;
		this.parity = parity;
		this.stopBits = stopBits;
		this.dataLength = dataLength;
		this.buffer = new byte[bufferSize];
	}
	
	public void connect() throws InterruptedException{
			serialPort = SerialPort.getCommPort(this.port);
			serialPort.setComPortParameters(baudrate, dataLength, stopBits, parity);
			//serialPort.setComPortTimeouts(SerialPort.T, 0, 0);
			serialPort.openPort();
			serialPort.addDataListener(this);
	}

	public byte[] read(int bytecount){
		serialPort.readBytes(buffer, bytecount);
		return buffer;
	}
	
	
	public byte[] firstConnection(){
		serialPort.readBytes(buffer, 4);
		return buffer;
	}
	
	public void send(byte[] s){
		serialPort.writeBytes(s, s.length);
	}
	
	public byte[] recieve(byte[] s, int bytecount){
		send(s);
		return read(bytecount);
	}
	public void disconnect(){
		serialPort.closePort();
		System.out.println("[ARDUINO_INTERFACE] Port closed");
	}
	
	public InputStream getInputStream(){
		return serialPort.getInputStream();
	}
	
	public OutputStream getOutputStream(){
		return serialPort.getOutputStream();
	}

	public int getListeningEvents() {
		return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
	}

	public void serialEvent(SerialPortEvent e) {
		if (e.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
	         return;
		byte[] newData = new byte[serialPort.bytesAvailable()];
		serialPort.readBytes(newData, newData.length);
		String d  = "";
		d = new String(newData);
		if(d.startsWith("@") && d.endsWith("\n") && d.getBytes().length <= 12){
			System.out.println("Data: " + d);
		}
	}
}

	