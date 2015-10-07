package com.maker2222.drone.network;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.maker2222.drone.geolocation.Location;

public class WeatherHandler {
	private static Table<Double, Double, Weather> mapGrid = HashBasedTable.create();
	
	public static Weather addPoint(Location loc, Weather w){
		double lat = loc.getLat();
		double lon =  loc.getLon();
		mapGrid.put(lat, lon, w);
		return w;
	}
}
