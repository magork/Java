package experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class WeatherXml {

public static void main(String[] args) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Budapest,hu&units=metric&mode=xml&APPID=a62f2d1fc9211a01bf063e91a5e352db");
        InputStream is = url.openStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String tartalom = br.lines().collect(Collectors.joining("\n"));
//        System.out.println(tartalom);
     
        
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     DocumentBuilder db = dbf.newDocumentBuilder();
     Document doc = db.parse(is);
     
     NodeList nodeList = doc.getElementsByTagName("temperature");
     
     if (nodeList.getLength() != 1) {
         throw new RuntimeException("Invalid file");
     }
     Node temperatureNode = nodeList.item(0);
     NamedNodeMap attributes =  temperatureNode.getAttributes();
     Node valueNode = attributes.getNamedItem("value");
     double temperature = Double.valueOf(valueNode.getNodeValue());
        System.out.println(temperature);
     
    }
}
