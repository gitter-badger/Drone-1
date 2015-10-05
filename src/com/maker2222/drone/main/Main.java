package com.maker2222.drone.main;


import java.io.IOException;

import com.maker2222.drone.droneinterface.SerialCom;

import jssc.SerialPortException;


public class Main {
	
 public static String apiKey;
 public static double angle;
	
	public static void main(String[] args) throws IOException, SerialPortException, InterruptedException{
		//new JsonRequest().start();
		apiKey = ReadKey.key();
		angle = Tracing.trace(10, 10);
		System.out.println(angle);
		//Cmd.comm();
		SerialCom.openComm();
	}
}
