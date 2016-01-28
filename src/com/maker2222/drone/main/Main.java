package com.maker2222.drone.main;

import java.io.IOException;
import java.io.PrintWriter;

import com.maker2222.drone.control.Control;
import com.maker2222.drone.droneinterface.SerialCom;
import com.maker2222.drone.network.UDPListener;


public class Main {
	
 public static String apiKey;
 public static double angle;
 public static boolean connected = true;
 //private static JsonRequest json;
 public static byte[] OK = new String("OK").getBytes();
private static SerialCom comm;

	
	public static void main(String[] args) throws Exception{
		
		Thread control = new Control();
		control.start();
		/*
		json = new JsonRequest("Boadilla del Monte");
		ScheduledThreadPoolExecutor e = new ScheduledThreadPoolExecutor(1);
		e.scheduleAtFixedRate(new Runnable() {
			
			public void run() {
				json.request();
				
			}
		}, 5, 5, TimeUnit.SECONDS);

		apiKey = ReadKey.key();
		*/
		comm = new SerialCom("COM9", 115200, 8, 1, 0, 4);
		comm.connect();
		UDPListener.bind();
		String a = "OKEY";
		Thread.sleep(1500);
		/*
		PrintWriter pr = new PrintWriter(comm.getOutputStream());
		while(true){
			while(comm.read(4) == null){
				comm.getOutputStream().write(a.getBytes());
				pr.flush();
			}
		}*/
		//System.out.println(Tracing.trace(1, 1));
	}
}