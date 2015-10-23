package com.maker2222.drone.util;

public class StringUtil {
	private double[] array;

	public double[] toDoubleArray(String[] s){
		if(s != null)
			for(int i = 0; i <= s.length; i++){
				array[i] = Double.parseDouble(s[i]);
			}
		return array;
	}
}
