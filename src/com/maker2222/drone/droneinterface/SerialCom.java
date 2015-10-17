package com.maker2222.drone.droneinterface;

import com.maker2222.drone.main.Main;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class SerialCom implements SerialPortEventListener{
	public SerialPort serialPort;
	public boolean connected = false;
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
	
	public SerialCom(String port, int baudrate, long delay) throws SerialPortException{
		this.port = port;
		this.baudrate = baudrate;
		this.delay = delay;
	}
	
	public void serialEvent(SerialPortEvent e) {
		if(e.isRXCHAR() == true && conn().equals("hola")){
			send("ok");
		    System.out.println("[ARDUINO_INTERFACE] Successfully connected to Arduino");
		    System.out.println("");
		}
	}
	
	
	/**Try to connect
	 * 
	 */
	public void connect(){
		try{
			serialPort = new SerialPort(port);
		    serialPort.openPort();
			serialPort.addEventListener(this);
		    serialPort.setParams(baudrate, 8, 1, 0);
		    Thread.sleep(delay);
		}
		catch(Exception e){
			System.out.println("[ARDUINO_INTERFACE] Check if Arduino is connected.");
			//e.printStackTrace();
		}
	}
	/**Read incoming data from serial port.
	 * 
	 */
	public String read(){
		String s = "";
		if(Main.connected == true){
			try {
				byte[] e = serialPort.readBytes();
				s = new String(e, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	private String conn(){
		String s = "";
		try {
			byte[] e = serialPort.readBytes();
			s = new String(e, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	/**Send a string through serial port
	 * 
	 * @param s : String to send.
	 */
	public void send(String s){
		try {
			serialPort.writeString(s);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
	/**Send a string through serial port
	 * and read the reply.
	 * 
	 * @param s String to send.
	 * @return String Message received.
	 */
	public String recieve(String s){
		send(s);
		return read();
	}
}

	