package com.maker2222.drone.geolocation;

import com.maker2222.drone.droneinterface.gpsLocation;

import geo.google.datamodel.GeoAltitude;
import geo.google.datamodel.GeoCoordinate;


public class LocationHandler {
	//public static GeoAddressStandardizer standarizer = new GeoAddressStandardizer(hola);
	public static GeoCoordinate coord = new GeoCoordinate(gpsLocation.latitude, gpsLocation.longitude, new GeoAltitude(gpsLocation.altitude));
}