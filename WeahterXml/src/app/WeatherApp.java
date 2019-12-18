package app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class WeatherApp {
	
	private JFrame frame = createFrame();
	
	public static void main(String[] args) {
		new WeatherApp();
	}

	
	
	
	public WeatherApp() {
		frame.setVisible(true);
	}




	private JFrame createFrame() {
		// TODO Auto-generated method stub WeatherApp
		
		JFrame frame = new JFrame("Weather");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(800,600));
		frame.setLayout(new BorderLayout());
		frame.add(createCurrentWeather(), BorderLayout.NORTH);
		frame.add(createChart(), BorderLayout.CENTER);
		
		return frame;
		
	}
	
	// teszt
	
	private Component createCurrentWeather() {
		
		try {
			WeatherWithIcon weather;
			weather = new WeatherDataProvider().downloadCurrentWeather();
			JPanel panel = new JPanel(); 
			panel.add(new JLabel(loadIcon(weather.getIcon())));
			
			panel.add(new JLabel(String.valueOf(weather.getTemperature())+" C"));
			return panel;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	
	}




	private ImageIcon loadIcon(String icon) {
		try {
			BufferedImage image= ImageIO.read(new URL("http://openweathermap.org/img/w/"+icon+".png"));
			return new ImageIcon(image);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}




	private Component createChart() {
		CategoryDataset generateDataset;
		try {
			generateDataset = generateDataset();
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
		JFreeChart chart = ChartFactory.createLineChart("Weather forecast", "hours","temperature", generateDataset);
		return new ChartPanel(chart);
	
	}




	private CategoryDataset generateDataset() throws JsonIOException, JsonSyntaxException, IOException {

		WeatherDataProvider provider = new WeatherDataProvider();
		List <Weather> weatherInfo = provider.downloadForecast();
		WeatherConverter weatherConverter = new WeatherConverter(); 
		
		return weatherConverter.convert(weatherInfo);
	}

}
