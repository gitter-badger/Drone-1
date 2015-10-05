package com.maker2222.drone.droneinterface;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class SerialCom implements SerialPortEventListener{
	public static SerialPort serialPort;
	public static boolean connected = false;
	
	public static boolean openComm() throws SerialPortException{
		try{
			serialPort = new SerialPort("COM9");
		    serialPort.openPort();
			serialPort.addEventListener(new SerialCom());
		    serialPort.setParams(115200, 8, 1, 0);
		    Thread.sleep(1000);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void serialEvent(SerialPortEvent e) {
		if(e.isRXCHAR() == true){
			System.out.print(read());
			send("led");
		}
	}
	
	private String read(){
		String s = "";
		try {
			byte[] e = serialPort.readBytes();
			s = new String(e, "US-ASCII");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static void send(String s){
		try {
			serialPort.writeString(s);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}
}

	
