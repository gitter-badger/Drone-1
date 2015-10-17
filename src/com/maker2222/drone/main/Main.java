package com.maker2222.drone.main;

import com.maker2222.drone.droneinterface.SerialCom;
import com.maker2222.drone.network.JsonRequest;


public class Main {
	
 public static String apiKey;
 public static double angle;
 public static boolean connected = false;
	
	public static void main(String[] args) throws Exception{
		SerialCom communication = new SerialCom("COM9", 115200, 1200);
		communication.connect();
		JsonRequest json = new JsonRequest("Madrid");
		json.makeReq();
		json.run();
		apiKey = ReadKey.key();
		System.out.println(Tracing.trace(1, 1));
	}
}
