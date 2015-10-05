package com.maker2222.drone.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadKey {

	public static String line = "";
	public static String key() throws IOException{
		FileInputStream is = new FileInputStream(new File("key.txt"));
		FileReader file = new FileReader("key.txt");
		BufferedReader in = new BufferedReader(file);
			line = in.readLine();
			in.close();
			return(line);
	}
}
