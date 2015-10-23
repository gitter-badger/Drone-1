package com.maker2222.drone.network;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.maker2222.drone.geolocation.Location;

/**
 * 
 * @author Alex (maker2222)
 *	This class manages all
 */

public class Weather {
	private static Table<Double, Double, WeatherObject> mapGrid = HashBasedTable.create();
	
	public static WeatherObject addPoint(Location loc, WeatherObject w){
		double lat = loc.getLat();
		double lon =  loc.getLon();
		mapGrid.put(lat, lon, w);
		return w;
	}
	
	public Weather removePont(Double x, Double y){
		mapGrid.remove(x, y);
		return this;
	}
}
