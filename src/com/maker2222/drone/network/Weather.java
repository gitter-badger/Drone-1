package com.maker2222.drone.network;

public class Weather {
	private String forecast;
	private float temperature;
	private int time;
	public Weather(String fc, float temp, int dt /* Time-date*/){
		this.forecast = fc;
		this.temperature = temp;
		this.time = dt;
	}
	
	public boolean isClear(){
		if (forecast == "Clear"){	
			return true;
		}
		else{
			return false;
		}
	}
	
	public float getTemp(){
		return temperature;
	}
	public String getFc(){
		return forecast;
	}
	public int getTime(){
		return time;
	}
}
