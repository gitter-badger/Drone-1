package com.maker2222.drone.geolocation;

import com.maker2222.drone.droneinterface.SerialCom;
import com.maker2222.drone.geolocation.Location;

public class LocationHandler {
	public static void getLocation(){

		double lat = Double.valueOf(SerialCom.recieve("getLon"));
		double lon = Double.valueOf(SerialCom.recieve("getLat"));
		double alt = Double.valueOf(SerialCom.recieve("getAlt"));
		@SuppressWarnings("unused")
		Location loc = new Location(lat, lon, alt);
	}
	
}