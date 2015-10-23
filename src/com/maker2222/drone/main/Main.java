package com.maker2222.drone.main;

import com.maker2222.drone.droneinterface.SerialCom;
import com.maker2222.drone.network.JsonRequest;


public class Main {
	
 public static String apiKey;
 public static double angle;
 public static boolean connected = false;
 public static SerialCom communication = new SerialCom("COM9", 115200, 1200);
	
	public static void main(String[] args) throws Exception{
		JsonRequest json = new JsonRequest("Madrid");
		json.makeReq();
		json.parse();
		apiKey = ReadKey.key();
		System.out.println(Tracing.trace(1, 1));
		communication.create();
		communication.connect();
		Thread.sleep(1000);
		while(true){
			String s = communication.recieve("getLoc");
			System.out.println(s);
		}
		//while(true) Cmd.commands();
	}
}