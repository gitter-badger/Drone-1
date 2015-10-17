package com.maker2222.drone.main;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadKey {

	public static String line = "";
	public static String key(){
		FileReader file;
		try {
			file = new FileReader("key.txt");
			BufferedReader in = new BufferedReader(file);
			line = in.readLine();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;

	}
}
