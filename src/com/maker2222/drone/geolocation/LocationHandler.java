package com.maker2222.drone.geolocation;

import com.maker2222.drone.main.Main;

public class LocationHandler {
	public static void getLocation(){
		double lat = Double.valueOf(Main.communication.recieve("getLon"));
		double lon = Double.valueOf(Main.communication.recieve("getLat"));
		double alt = Double.valueOf(Main.communication.recieve("getAlt"));
		@SuppressWarnings("unused")
		Location loc = new Location(lat, lon, alt);
	}
	
}