package com.maker2222.drone.main;

public class Tracing {
	
	public static Double pi = 3.14;
	
	public static double trace(double x, double y){
		double angle = Math.atan2(y, x);
		String d = Double.toString(((angle*180)/pi)).substring(0,6);
		return Double.valueOf(d);
	}
}
