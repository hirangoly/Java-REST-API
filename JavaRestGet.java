import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;


public class HttpGetter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//String sXML = HttpGetter
	      //      .getDoc("http://api.geonames.org/weatherIcao?ICAO=LSZH&username=rheh&style=full");
		String sXML = HttpGetter
	            .getDoc("https://public-api.wordpress.com/rest/v1/sites/en.blog.wordpress.com/posts/7/?pretty=1");
	 
	    Document dom = HttpGetter.loadXMLFromString(sXML);
	 
	    Element el = dom.getDocumentElement();
	 
	    System.out.println(HttpGetter.getTextValue(el, "title"));
	    System.out.println(HttpGetter.getTextValue(el, "content"));

	}

	public static String getDoc(String urlToRead) {
		 
	    URL url;
	    HttpURLConnection conn;
	    BufferedReader rd;
	    String line;
	    String result = "";
	 
	    try {
	 
	        url = new URL(urlToRead);
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");	        
	         
	        rd = new BufferedReader(
	                new InputStreamReader(conn.getInputStream()));
	 
	        while ((line = rd.readLine()) != null) {
	            result += line;
	        }
	 
	        rd.close();
	 
	    } catch (Exception e) {
	 
	        e.printStackTrace();
	 
	    }
	 
	    return result;
	}
	public static Document loadXMLFromString(String xml) throws Exception {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return (Document) builder.parse(is);
	}	
	
	private static String getTextValue(Element ele, String tagName) {
	    String textVal = null;
	    NodeList nl = ele.getElementsByTagName(tagName);
	    if (nl != null && nl.getLength() > 0) {
	        Element el = (Element) nl.item(0);
	        textVal = el.getFirstChild().getNodeValue();
	    }
	 
	    return textVal;
	}

}
