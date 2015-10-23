package com.maker2222.drone.droneinterface;

import jssc.SerialPortEvent;

public interface Connection {
	void serialEvent(SerialPortEvent e);
	
	void connect();
	
	/**
	 * Send a connection request
	 * 
	 * @return Response
	 */
	String firstConnection();
	
	/**Read incoming data from serial port.
	 * 
	 * @return Incoming data as string;
	 */
	String read();
	
	/**Send a string through serial port
	 * 
	 * @param s : String to send.
	 */
	void send(String s);
	
	/**Send a string through serial port
	 * and read the reply.
	 * 
	 * @param s String to send.
	 * @return String Message received.
	 */
	String recieve(String s);
	
	void disconnect();
}
