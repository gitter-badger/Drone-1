package com.maker2222.drone.control;

public class Control extends Thread{


	@Override
	public void start(){
		control();
	}
	
	
	
	public void control(){
		PID instance = new PID();
		float error = 10;
		int i = 0;
		while(true){
			error = instance.planta(error, instance.pid(error));
			System.out.println(error + ":" + instance.dt);
			i++;
		}
	}
}
