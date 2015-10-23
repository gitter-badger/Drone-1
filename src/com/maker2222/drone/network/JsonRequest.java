package com.maker2222.drone.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.maker2222.drone.main.ReadKey;

/**Must explain what this does
 * 
 * @author Alex
 *
 */
public class JsonRequest extends Thread{
	public static File json = new File("data.json");
	public static Date fecha = new Date ();
	public static WeatherObject w;
	private String city;
	private String key;
	
	/**This represents an incoming request to the API.
	 * 
	 * @param city : City where to get the forecast.
	 */
	public JsonRequest(String city){
		this.city = city;
		this.key = ReadKey.key();
	}
	
	private FileOutputStream out;
	/**Makes the request to the API
	 * 
	 * @return FileOutputStream
	 * @throws Exception
	 */
	public FileOutputStream makeReq() throws Exception{
		try{
			String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&lang=sp&units=metric&APPID=" + key;
			URL website = new URL(url); //Http request
			ReadableByteChannel in = Channels.newChannel(website.openStream());
			out = new FileOutputStream("data.json");
			out.getChannel().transferFrom(in, 0, Long.MAX_VALUE);	//Write http response to "data.json" file
			out.close();

			}
			catch(IOException e){
				System.out.println("[NETWORK] ERROR DE CONEXION");
				PrintStream stream = new PrintStream("error.log");
				e.printStackTrace(stream);
			}
		return out;
	}

	/**Create a {@link WeatherObject} object with the data
	 * from the received Json.
	 * @return 
	 * @return Weather object created.
	 * @throws IOException
	 */
	public WeatherObject parse() throws IOException{
		InputStream is = new FileInputStream(json);
		String jsonTxt = IOUtils.toString(is);
		//System.out.println(jsonTxt);
		JSONObject obj = new JSONObject(jsonTxt);
		JSONArray arr = obj.getJSONArray("weather");
	    JSONObject obj2 = obj.getJSONObject("main");
		for (int i = 0; i < arr.length(); i++)
		{
			System.out.println(obj.getString("name")); //Print location name
			int time = obj.getInt("dt");
			fecha.setTime((long)time*1000);
			System.out.println("	" + fecha); //Print date (converted from UTC)
		    String main = arr.getJSONObject(i).getString("main"); //Print main prediction
		    System.out.println("		" + main);
		    System.out.println("		" + obj2.getInt("temp") + " C"); //Print temperature
		}
		w = new WeatherObject(arr.getJSONObject(0).getString("main"), obj2.getInt("temp"), obj.getInt("dt"));
		System.out.println(w.getFc());
		return w;
	}
}