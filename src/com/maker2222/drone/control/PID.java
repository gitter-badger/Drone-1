package com.maker2222.drone.control;

public class PID extends Planta{
/*	ei=ei+ep*dt;
	ed=(ep-ep1)/dt
s=k*ep+ki*ei+kd*ed
ep1=ep;
ep=ep1-l*cl*s/I
*/
	public long dt = 0;
	private static float error_anterior = 0;
	private static float error_integral = 0;
	public float[] k = {0.6F, 0.0F, -0.02F};
	
	public float pid(float error){
		long dt1 = System.currentTimeMillis();
		error_integral += error*dt;
		float ed = (error - error_anterior)/dt1;
		float s = k[0]*error +k[1]*error_integral + k[2]*ed;
		error_anterior = error;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dt = System.currentTimeMillis();
		dt -= dt1;
		return s;
	}

	@Override
	public float planta(float error, float actuacion) {
		error -= actuacion;
		return error;
	}
}