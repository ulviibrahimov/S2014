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

import com.socar.hrsocar.model.LcsItem;

	public class LicenseParser extends DefaultHandler{
	private LcsItem lcsItem;
	List<LcsItem> lcsItemList= new ArrayList<LcsItem>();
	protected StringBuilder serialNumberSb;
	protected StringBuilder issuanceDateSb;
	protected StringBuilder issuingAuthoritySb;
	protected StringBuilder expirationDateSb;
	protected StringBuilder categorySb;
	protected StringBuilder seriesSb;
	boolean newLcsItemFlag=true;
	private String inputXml;
	public LicenseParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
		public List<LcsItem> getResult(){
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = saxParserFactory.newSAXParser();
				DefaultHandler defaultHandler = new DefaultHandler(){
				String lcsItemTag="close";  
			    String serialNumberTag="close";
			    String issuanceDateTag="close";  
			    String issuingAuthorityTag="close";
			    String expirationDateTag="close";
			    String categoryTag="close";
			    String seriesTag="close";
			    @Override
				public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
			    	if (tagName.equalsIgnoreCase("EDriversLicense")) {  
			    		lcsItemTag = "open";
				    }

			    	if (tagName.equalsIgnoreCase("SERIAL_NUMBER")) {  
			    		serialNumberTag = "open";
			    		serialNumberSb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("category")) {  
			    		categoryTag = "open";
			    		categorySb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("ISSUANCE_DATE")) {  
			    		issuanceDateTag = "open";
			    		issuanceDateSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("ISSUING_AUTHORITY")) {  
			    		issuingAuthorityTag = "open";
			    		issuingAuthoritySb=new StringBuilder();
				    }  
			    	if (tagName.equalsIgnoreCase("EXPIRATION_DATE")) {  
			    		expirationDateTag = "open";  
			    		expirationDateSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("series")) {  
			    		seriesTag = "open";  
			    		seriesSb=new StringBuilder();
				    }
			    } 	
			    @Override
				public void characters(char ch[], int start, int length)throws SAXException { 
			    	if (lcsItemTag.equals("open")) {  
			    		if(newLcsItemFlag){
				    		 lcsItem = new LcsItem();
				    		 newLcsItemFlag=false;
				    	 }
				    }
			    	if (serialNumberTag.equals("open")) {  
					 	 if (serialNumberSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	serialNumberSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (issuanceDateTag.equals("open")) {  
					 	 if (issuanceDateSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	issuanceDateSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (issuingAuthorityTag.equals("open")) {  
					 	 if (issuingAuthoritySb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	issuingAuthoritySb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (expirationDateTag.equals("open")) {  
					 	 if (expirationDateSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	expirationDateSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (categoryTag.equals("open")) {  
					 	 if (categorySb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	categorySb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (seriesTag.equals("open")) {  
					 	 if (seriesSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	seriesSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    }  
			    
			    @Override
				public void endElement(String uri, String localName, String tagName)  
			    	throws SAXException {  
					   	if (tagName.equalsIgnoreCase("EDriversLicense")) {  
					   		lcsItemTag = "close";    
						    newLcsItemFlag=true;
						    lcsItemList.add(lcsItem);
					   	}  
					   	if (tagName.equalsIgnoreCase("SERIAL_NUMBER")) {  
					   		serialNumberTag = "close"; 
					   		lcsItem.setSerialNumber(serialNumberSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ISSUANCE_DATE")) {  
					   		issuanceDateTag = "close";  
					   		lcsItem.setIssuanceDate(issuanceDateSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ISSUING_AUTHORITY")) {  
					   		issuingAuthorityTag = "close";
					   		lcsItem.setIssuingAuthority(issuingAuthoritySb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("EXPIRATION_DATE")) {  
					   		expirationDateTag = "close";  
					   		lcsItem.setExpirationDate(expirationDateSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("category")) {  
					   		categoryTag = "close";  
					   		lcsItem.setCategory(categorySb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("series")) {  
					   		seriesTag = "close";  
					   		lcsItem.setSeries(seriesSb.toString().trim());
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
		return lcsItemList;
	}
}
