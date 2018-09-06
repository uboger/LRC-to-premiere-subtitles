package technology.uboger.dao;

import java.net.URL;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;

public class XMLNameSpace {
	private Map<String,String> attributes;

	public XMLNameSpace(String url) throws DocumentException {
		Document doc = XMLTools.parse(url);
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	

}
