package com.maker2222.drone.geolocation;

import geo.google.datamodel.GeoCoordinate;


public class LocationHandler {
	public static void getLocation(){

		double lat = SerialCom.recieve("getX");
		double lon = SerialCom.recieve("getY");
		Location pos = new Location();
	}
	
}