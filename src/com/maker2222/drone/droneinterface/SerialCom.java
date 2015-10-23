package com.maker2222.drone.droneinterface;

import com.maker2222.drone.main.Main;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class SerialCom implements SerialPortEventListener, Connection{
	public SerialPort serialPort;
	public boolean connected = true;
	public byte[] buffer = new byte[1024];
	private String port;
	private int baudrate;
	private long delay;
	
	/** SerialComm object, represents a connection with Arduino. When conected
	 * Arduino is rebooted.
	 * 
	 * @param port : Port where Arduino is conencted.
	 * 
	 * @param baudrate : Baudrate to connect.
	 * 
	 * @param delay : Time that costs Arduino to reboot.
	 */
	
	public SerialCom(String port, int baudrate, long delay){
		this.port = port;
		this.baudrate = baudrate;
		this.delay = delay;
	}
	
	public void serialEvent(SerialPortEvent e) {
		/*
		if(e.isRXCHAR() == true && firstConnection().equals("hola") && connected == false){
			send("ok");
		    System.out.println("[ARDUINO_INTERFACE] Successfully connected to Arduino");
		    System.out.println("");
		}
		
		if(e.isRXCHAR() == true){
			String s = read();
		    System.out.println(s);
		}
		*/
	}
	public void create(){
		serialPort = new SerialPort(port);
	}
	
	/**Try to connect
	 * 
	 */
	public void connect(){
			try{
			    serialPort.openPort();
				serialPort.addEventListener(this);
			    serialPort.setParams(baudrate, 8, 1, 0);
			    Thread.sleep(delay);
			}
			catch(Exception e){
				System.out.println("[ARDUINO_INTERFACE] Check if Arduino is connected.");
				//e.printStackTrace();
			}
			return;
	}

	public String read(){
		String s = "";
		if(Main.connected == true){
			try {
				byte[] buffer = serialPort.readBytes();
				s = new String(buffer);
				s = serialPort.readString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return s;
	}
	
	
	public String firstConnection(){
		String s = "";
		try {
			byte[] e = serialPort.readBytes();
			s = new String(e, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public void send(String s){
		try {
			serialPort.writeBytes(s.getBytes());
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
	
	public String recieve(String s){
		send(s);
		return read();
	}
	public void disconnect(){
		try {
			serialPort.closePort();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
		System.out.println("[ARDUINO_INTERFACE] Port closed");
	}
}

	