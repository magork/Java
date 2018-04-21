package app;

import java.util.Date;

public class WeatherWithIcon extends Weather {
	
	public WeatherWithIcon(Date time, double temperature, String icon) {
		super(time, temperature);
		this.icon = icon;
		
	}

	private String icon;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "WeatherWithIcon [icon=" + icon + ", time=" + time + ", temperature=" + temperature + "]";
	}


	
	

}
