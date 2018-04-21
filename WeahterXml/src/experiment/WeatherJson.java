package experiment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class WeatherJson {

	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException{
		
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Budapest,hu&units=metric&APPID=a62f2d1fc9211a01bf063e91a5e352db");
		JsonParser parser = new JsonParser();
		JsonElement rootElement = parser.parse(new InputStreamReader(url.openStream()));
		JsonObject rootElementAsJsonObject = rootElement.getAsJsonObject();
		JsonElement mainElement = rootElementAsJsonObject.get("main");
		JsonObject mainElementAsJsonObject = mainElement.getAsJsonObject();
		JsonElement tempElement = mainElementAsJsonObject.get("temp");
		double temperature = tempElement.getAsDouble();
		System.out.println(temperature);
	
	}
}
