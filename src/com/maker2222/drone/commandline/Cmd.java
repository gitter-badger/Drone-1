package com.maker2222.drone.commandline;

import java.io.InputStream;
import java.util.Scanner;

import com.maker2222.drone.main.Main;

import jssc.SerialPortException;


public class Cmd {
	public static Scanner sc;
	private static InputStream is;
	public static void commands() throws SerialPortException{
		is = System.in;
		sc = new Scanner(is);
		if(sc.nextLine().equalsIgnoreCase("openPort")){
			Main.communication.connect();
		}
		if(sc.nextLine().equalsIgnoreCase("closePort")){
			Main.communication.disconnect();
		}
		if(sc.nextLine().equalsIgnoreCase("recieve")){
			Main.communication.recieve("getLoc");
		}
	}
}
