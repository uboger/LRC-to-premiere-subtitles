package debug.uboger.com;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import technology.uboger.dao.XMLTools;

public class ForXMLDom {
	
	@Test
	public void createXmlTest(){
	       Document document = DocumentHelper.createDocument();
	        Element root = document.addElement( "root" );

	        Element author1 = root.addElement( "author" )
	            .addAttribute( "name", "James" )
	            .addAttribute( "location", "UK" )
	            .addText( "James Strachan" );
	        
	        Element author2 = root.addElement( "author" )
	            .addAttribute( "name", "Bob" )
	            .addAttribute( "location", "US" )
	            .addText( "Bob McWhirter" );

	        try {
				XMLWriter writer = new XMLWriter(
				        new FileWriter( "output.xml" ));
				 OutputFormat format = OutputFormat.createPrettyPrint();
			    format = OutputFormat.createCompactFormat();
		        writer = new XMLWriter( System.out, format );
		        writer.write( document );
		        writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	@Test
	public void namexpace(){
		try {
			Document doc  = XMLTools.parse("xmlnamespace.xml");
			XMLTools.bar(doc, null);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
