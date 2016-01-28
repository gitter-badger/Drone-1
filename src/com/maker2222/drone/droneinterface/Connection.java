package com.maker2222.drone.droneinterface;

public interface Connection {

	void connect() throws InterruptedException;
	
	/**
	 * Send a connection request
	 * 
	 * @return Response
	 */
	byte[] firstConnection();
	
	/**Read incoming data from serial port.
	 * 
	 * @return Incoming data.
	 */
	byte[] read(int bytecount);
	
	/**Send bytes through serial port
	 * 
	 * @param b : Bytes to send.
	 */
	void send(byte[] b);
	
	/**Send data through serial port
	 * and read the reply.
	 * 
	 * @param b Bytes to send.
	 * @return Bytes received.
	 */
	byte[] recieve(byte[] b, int bytecount);
	
	void disconnect();
}
