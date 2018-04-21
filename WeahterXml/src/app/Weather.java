package app;

import java.util.Date;

public class Weather {
	
	protected Date time;
	
	protected double temperature;
	
	
	public Weather(Date time, double temperature) {
		
		this.time = time;
		this.temperature = temperature;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Weather [time=" + time + ", temperature=" + temperature + "]";
	}


	
	

}
