package com.maker2222.drone.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import com.maker2222.drone.control.Rotation;


/*	Some tests with sending UDP packets containing
 * 	rotation angle, just for testing with Android
 * 	phone (Instead of a gyroscope connected to the
 * 	arduino).
 */

public class UDPListener {
	public static DatagramSocket socket; //Constructor for the socket
	public static ByteBuffer buffer = ByteBuffer.allocateDirect(1024); //Buffer to store the incoming data
	private static byte[] b = new byte[1024];
	public static DatagramPacket packet = new DatagramPacket(b, b.length);
	public static String[] list;  //String array conversion from the buffer
	public static Rotation r = new Rotation(0.0, 0.0, 0.0);
	
	public static void bind() throws SocketException{
		socket = new DatagramSocket(5555);  //Listen on port 5555
	}
	
	public static void udp() throws IOException, InterruptedException{
		socket.receive(packet);  //Recieve data and store it in the byte array
		recieve();
	}
	
	private static void recieve() throws IOException, InterruptedException{
		socket.receive(packet);	
		buffer = ByteBuffer.wrap(b);
		final FloatBuffer bf = buffer.asFloatBuffer();
		r.setX(toDouble(bf.get(6)*57.29));
		r.setY(toDouble(bf.get(7)*57.29));
		r.setZ(toDouble(bf.get(8)*57.29));
	}
	
	public static double toDouble(double d){
		final String s = Double.toString(d);
		final String s1 = s.substring(0, s.lastIndexOf("."));
		final String s2 = s.substring(s.indexOf("."), s.indexOf(".")+2);
		final double ds = Double.parseDouble(s1 + s2);
		return ds;
	}
}
