package app;

import java.util.Date;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class WeatherConverter {
	
	public CategoryDataset convert(List<Weather> weatherInfo) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (Weather weatherElement : weatherInfo){
			Integer hours = getHours(weatherElement);
			double temp = weatherElement.getTemperature();
			dataset.addValue(temp, "temperature", hours);
		}
		
		return dataset;
	}

	private int getHours(Weather weatherElement) {
		Date date = weatherElement.getTime();
		long difference = date.getTime()-System.currentTimeMillis();
		difference = difference / 1000 / 3600;
		return (int ) difference;
	}

}
