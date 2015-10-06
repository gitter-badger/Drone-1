package com.maker2222.drone.geolocation;

public class Location {
	public double latitude;
	public double longitude;
	public double altitude;
	
	public Location(double lat, double lon, double alt){
		this.latitude = lat;
		this.longitude = lon;
		this.altitude = alt;
	}
	
	public double getLat(){
		return this.latitude;
	}
	
	public double getLon(){
		return this.longitude;
	}
	
	public double getAlt(){
		return this.altitude;
	}
  
    public void sumLat(double la){
        this.latitude = this.latitude + la;
        return this;
    }
    
    public void sumLon(double lo){
        this.longitude = this.longitude + lo;
        return this;
    }
    
    public void sumAlt(double al){
        this.altitude = this.altitude + al;
        return this;
    }
}