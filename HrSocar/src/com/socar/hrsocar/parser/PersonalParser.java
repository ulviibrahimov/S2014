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

import com.socar.hrsocar.model.PrsnlItem;

public class PersonalParser extends DefaultHandler{
	private PrsnlItem prsnlItem;
	List<PrsnlItem> prsnlItemList= new ArrayList<PrsnlItem>();
	protected StringBuilder serialNumberSb;
	protected StringBuilder issuanceDateSb;
	protected StringBuilder issuingAuthoritySb;
	protected StringBuilder expirationDateSb;
	protected StringBuilder pinCodeSb;
	boolean newPrsnlItemFlag=true;
	private String inputXml;
	public PersonalParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
		public List<PrsnlItem> getResult(){
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = saxParserFactory.newSAXParser();
				DefaultHandler defaultHandler = new DefaultHandler(){
				String prsnlItemTag="close";  
			    String serialNumberTag="close";
			    String issuanceDateTag="close";  
			    String issuingAuthorityTag="close";
			    String expirationDateTag="close";
			    String pinCodeTag="close";
			    @Override
				public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
			    	if (tagName.equalsIgnoreCase("EPersonalInfo")) {  
			    		prsnlItemTag = "open";
				    }

			    	if (tagName.equalsIgnoreCase("ID_SERIAL_NUMBER")) {  
			    		serialNumberTag = "open";
			    		serialNumberSb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("ID_PIN_CODE")) {  
			    		pinCodeTag = "open";
			    		pinCodeSb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("ID_ISSUANCE_DATE")) {  
			    		issuanceDateTag = "open";
			    		issuanceDateSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("ID_ISSUING_AUTHORITY")) {  
			    		issuingAuthorityTag = "open";
			    		issuingAuthoritySb=new StringBuilder();
				    }  
			    	if (tagName.equalsIgnoreCase("EXPIRATION_DATE")) {  
			    		expirationDateTag = "open";  
			    		expirationDateSb=new StringBuilder();
				    }
			    } 	
			    @Override
				public void characters(char ch[], int start, int length)throws SAXException { 
			    	if (prsnlItemTag.equals("open")) {  
			    		if(newPrsnlItemFlag){
				    		 prsnlItem = new PrsnlItem();
				    		 newPrsnlItemFlag=false;
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
			    	if (pinCodeTag.equals("open")) {  
					 	 if (pinCodeSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	pinCodeSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    }  
			    
			    @Override
				public void endElement(String uri, String localName, String tagName)  
			    	throws SAXException {  
					   	if (tagName.equalsIgnoreCase("EPersonalInfo")) {  
					   		prsnlItemTag = "close";    
						    newPrsnlItemFlag=true;
						    prsnlItemList.add(prsnlItem);
					   	}  
					   	if (tagName.equalsIgnoreCase("ID_SERIAL_NUMBER")) {  
					   		serialNumberTag = "close"; 
					   		prsnlItem.setSerialNumber(serialNumberSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ID_ISSUANCE_DATE")) {  
					   		issuanceDateTag = "close";  
					   		prsnlItem.setIssuanceDate(issuanceDateSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ID_ISSUING_AUTHORITY")) {  
					   		issuingAuthorityTag = "close";
					   		prsnlItem.setIssuingAuthority(issuingAuthoritySb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("EXPIRATION_DATE")) {  
					   		expirationDateTag = "close";  
					   		prsnlItem.setExpirationDate(expirationDateSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ID_PIN_CODE")) {  
					   		pinCodeTag = "close";  
					   		prsnlItem.setPinCode(pinCodeSb.toString().trim());
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
		return prsnlItemList;
	}
}
