package app;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import generated.RootObject;

public class WeatherDataProvider {
	
	public static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?q=Budapest&APPID=a62f2d1fc9211a01bf063e91a5e352db";
	
	public static final String ACTUAL_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Budapest,hu&units=metric&APPID=a62f2d1fc9211a01bf063e91a5e352db";
	
	public List<Weather> downloadForecast() throws JsonIOException, JsonSyntaxException, IOException {
	
		JsonObject rootObject =	downloadJson(FORECAST_URL);
		JsonArray forecastArray = rootObject.get("list").getAsJsonArray();
		List<Weather> result = new ArrayList<>();
		for (int i =0; i< forecastArray.size() && i < 24 ; i++)
		{
		JsonObject forecastElement = forecastArray.get(i).getAsJsonObject();
		Date date = new Date(forecastElement.get("dt").getAsLong() * 1000);
		double temperature = forecastElement.get("main").getAsJsonObject().get("temp").getAsDouble() - 273.15;
		Weather newWeather = new Weather(date,temperature);
		result.add(newWeather);
		}
		return result;
	}
	
	public WeatherWithIcon downloadCurrentWeather() throws MalformedURLException, IOException{
		JsonObject rootObject =	downloadJson(ACTUAL_WEATHER_URL);
		
		Gson gson = new Gson();
		
		RootObject convertedRootObject = gson.fromJson(rootObject, RootObject.class);
		
		
		//String icon = rootObject.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
		String icon = convertedRootObject.getWeather().get(0).getIcon();
		
		//Double temp = rootObject.get("main").getAsJsonObject().get("temp").getAsDouble();
		Long temp = convertedRootObject.getMain().getTemp();
		
		return new WeatherWithIcon(new Date(), temp, icon);
	}
		
		private JsonObject downloadJson(String urlParameter) throws MalformedURLException, IOException{
		URL url = new URL(urlParameter);
		JsonParser parser = new JsonParser();
		JsonElement rootElement = parser.parse(new InputStreamReader(url.openStream()));
		return rootElement.getAsJsonObject();
	
		}
		
		public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
			
			System.out.println(new WeatherDataProvider().downloadCurrentWeather());
			
		}
		
	}


