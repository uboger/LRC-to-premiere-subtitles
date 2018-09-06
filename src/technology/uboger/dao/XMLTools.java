package technology.uboger.dao;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLTools {
	   public static Document parse(String url) throws DocumentException {
	        SAXReader reader = new SAXReader();
	        Document document = reader.read(url);
	        return document;
	    }	
	   public static void bar(Document document,Map<String,String> attributes) throws DocumentException {

	        Element root = document.getRootElement();
	       List attrs =  root.attributes();
	        // iterate through child elements of root
	        for (Object attr :attrs) {
	            // do something
	        	
	        	attr = (Attribute)attr;
	        	
	        }

	     }
	   public static void write(Document document,String fileName) throws IOException {

	        // lets write to a file
	        XMLWriter writer = new XMLWriter(
	            new FileWriter( fileName)
	        );
	        writer.write( document );
	        writer.close();
	   }
}
