package WeatherDemo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

public class WeatherDemo {
    public static void main(String[] args) {
        String _url = "http://api.openweathermap.org/data/2.5/weather?q=hanoi," +
                "vn&APPID=66d9be5f6f21f670ac388097b92353d5&mode=xml";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(_url);
            NodeList nodeList = doc.getElementsByTagName("temperature");
            Node node = nodeList.item(0);
            Element e = (Element) node;
            String t = e.getAttribute("value");
            System.out.println(t);
        } catch (MalformedURLException e) {
        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
    }
}
