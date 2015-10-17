package com.maker2222.drone.commandline;

import java.io.InputStream;
import java.util.Scanner;

import jssc.SerialPortException;


public class Cmd {
	public static Scanner sc;
	private static InputStream is;
	public static void comm() throws SerialPortException{
		is = System.in;
		sc = new Scanner(is);
		if(sc.nextLine().equalsIgnoreCase("openPort")){

		}
		if(sc.nextLine().equalsIgnoreCase("closePort")){

		}
	}
}
