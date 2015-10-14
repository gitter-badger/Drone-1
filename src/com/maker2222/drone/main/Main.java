package com.maker2222.drone.main;

import java.io.IOException;

import com.maker2222.drone.droneinterface.SerialCom;
import com.maker2222.drone.network.JsonRequest;

import jssc.SerialPortException;


public class Main {
	
 public static String apiKey;
 public static double angle;
	
	public static void main(String[] args) throws IOException, SerialPortException, InterruptedException{
		new JsonRequest().start();
		apiKey = ReadKey.key();
		angle = Tracing.trace(1, 1);
		System.out.println(angle);
		SerialCom.openComm();
	}
}
