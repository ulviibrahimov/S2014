package com.socar.hrsocar.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.socar.hrsocar.model.DscpItem;

public class DisciplinaryParser extends DefaultHandler{
	private DscpItem dscpItem;
	List<DscpItem> dscpItemList= new ArrayList<DscpItem>();
	protected StringBuilder startDateSb;
	protected StringBuilder endDateSb;
	protected StringBuilder reasonsSb;
	protected StringBuilder resultSb;
	boolean newDscpItemFlag=true;
	private String inputXml;
	public DisciplinaryParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
		public List<DscpItem> getResult(){
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = saxParserFactory.newSAXParser();
				DefaultHandler defaultHandler = new DefaultHandler(){
				String dscpItemTag="close";  
			    String begdaTag="close";
			    String enddaTag="close";  
			    String reasonsTag="close";
			    String ysubtyTag="close";
			    @Override
				public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
			    	if (tagName.equalsIgnoreCase("item")) {  
			    		dscpItemTag = "open";
				    }
			    	if (tagName.equalsIgnoreCase("begda")) {  
			    		begdaTag = "open";
			    		startDateSb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("endda")) {  
			    		enddaTag = "open";
			    		endDateSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("reasons")) {  
			    		reasonsTag = "open";
			    		reasonsSb=new StringBuilder();
				    }  
			    	if (tagName.equalsIgnoreCase("ysubty")) {  
			    		ysubtyTag = "open";  
			    		resultSb=new StringBuilder();
				    }
			    } 	
			    @Override
				public void characters(char ch[], int start, int length)throws SAXException { 
			    	if (dscpItemTag.equals("open")) {  
			    		if(newDscpItemFlag){
				    		 dscpItem = new DscpItem();
				    		 newDscpItemFlag=false;
				    	 }
				    }
			    	if (begdaTag.equals("open")) {  
					 	 if (startDateSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					   	            startDateSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (enddaTag.equals("open")) {  
					 	 if (endDateSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					   	            endDateSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (reasonsTag.equals("open")) {  
					 	 if (reasonsSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	reasonsSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (ysubtyTag.equals("open")) {  
					 	 if (resultSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	resultSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    }  
			    
			    @Override
				public void endElement(String uri, String localName, String tagName)  
			    	throws SAXException {  
					   	if (tagName.equalsIgnoreCase("item")) {  
					   		dscpItemTag = "close";    
						    newDscpItemFlag=true;
						    dscpItemList.add(dscpItem);
					   	}  
					   	if (tagName.equalsIgnoreCase("begda")) {  
					   		begdaTag = "close"; 
					   		dscpItem.setStartDate(startDateSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("endda")) {  
					   		enddaTag = "close";  
					   		dscpItem.setEndDate(endDateSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("reasons")) {  
					   		reasonsTag = "close";
					   		dscpItem.setReason(reasonsSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ysubty")) {  
					   		ysubtyTag = "close";  
					   		dscpItem.setResult(resultSb.toString().trim());
					   	}
			    	}  
				};
				try {
					saxParser.parse(new InputSource(new StringReader(inputXml)), defaultHandler);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}  
		return dscpItemList;
	}
}