package com.maker2222.drone.control;

public class Rotation {
	public double xDg = 0.0;
	public  double yDg = 0.0;
	public  double zDg = 0.0;
	
	public Rotation(double x, double y, double z){
		this.xDg = x;
		this.yDg = y;
		this.xDg = z;
	}
	
	public double getX(){
		return this.xDg;
	}
	
	public double getY(){
		return this.yDg;
	}
	
	public double getZ(){
		return this.zDg;
	}
	
	public double getHash(){
		return xDg*yDg*zDg;
	}
	
	public void setX(double x){
		this.xDg = x;
	}
	
	public void setY(double y){
		this.xDg = y;
	}
	
	public void setZ(double z){
		this.xDg = z;
	}
}
