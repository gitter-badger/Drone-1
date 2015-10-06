package com.maker2222.drone.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadKey {

	public static String line = "";
	public static String key() throws IOException{
		FileReader file = new FileReader("key.txt");
		BufferedReader in = new BufferedReader(file);
			line = in.readLine();
			in.close();
			return(line);
	}
}
