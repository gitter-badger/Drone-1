package com.maker2222.drone.geolocation;

import com.maker2222.drone.droneinterface.SerialCom;

public class LocationHandler {
	public static void getLocation(){

		double lat = Double.valueOf(SerialCom.recieve("getLon"));
		double lon = Double.valueOf(SerialCom.recieve("getLat"));
		double alt = Double.valueOf(SerialCom.recieve("getAlt"));
		@SuppressWarnings("unused")
		Location pos = new Location(lat, lon, alt);
	}
	
}