package com.socar.hrsocar.parser;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LoginParser extends DefaultHandler{
	private String tagString="RResult";
	protected StringBuilder sb;
	private String inputXml;
	public LoginParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
		public String getResult(){
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = saxParserFactory.newSAXParser();
				DefaultHandler defaultHandler = new DefaultHandler(){
				private String resultTag="close";	
			    @Override
				public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
			    	if (tagName.equalsIgnoreCase("RResult")) {  
					 	 resultTag = "open";  
					   	 sb=new StringBuilder();
				     }  
			    } 	
			    @Override
				public void characters(char ch[], int start, int length)throws SAXException {  
			    	if (resultTag.equals("open")) {  
					 	 if (sb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					   	            sb.append(ch[i]);
					    	        }
					   	    }
				     }  
			    }  
			    
			    @Override
				public void endElement(String uri, String localName, String tagName)  
			    	throws SAXException {  
					   	if (tagName.equalsIgnoreCase("RResult")) {  
						      resultTag = "close";  
						     }  
					    }  
				};
				try {
					System.out.println("xmlxml:"+inputXml);
					saxParser.parse(new InputSource(new StringReader(inputXml)), defaultHandler);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}  
		return sb.toString().trim();
	}
}