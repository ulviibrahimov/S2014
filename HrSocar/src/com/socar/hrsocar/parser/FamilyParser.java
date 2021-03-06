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

import com.socar.hrsocar.model.FmlItem;
public class FamilyParser {
	private FmlItem fmlItem;
	List<FmlItem> fmlItemList= new ArrayList<FmlItem>();
	protected StringBuilder firstNameSb;
	protected StringBuilder lastNameSb;
	protected StringBuilder fatherNameSb;
	protected StringBuilder birthdaySb;
	boolean newFmlItemFlag=true;
	private String inputXml;
	
	public FamilyParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
	
	public List<FmlItem> getResult(){
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = saxParserFactory.newSAXParser();
			DefaultHandler defaultHandler = new DefaultHandler(){
			String fmlItemTag="close";  
		    String firstNameTag="close";
		    String lastNameTag="close";  
		    String birthdayTag="close";
		    String fatherNameTag="close";
		    String eChildInfoTag="close";
		    @Override
			public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
		    	if (tagName.equalsIgnoreCase("item")) {  
		    		fmlItemTag = "open";
			    }
		    	if (tagName.equalsIgnoreCase("eChildInfo")) {  
		    		eChildInfoTag = "open";
			    }  
		    	if (tagName.equalsIgnoreCase("Firstname")) {  
		    		firstNameTag = "open";
		    		firstNameSb=new StringBuilder();
			    }  
		    	
		    	if (tagName.equalsIgnoreCase("lastname")) {  
		    		lastNameTag = "open";
		    		lastNameSb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("fathersname")) {  
		    		fatherNameTag = "open";
		    		fatherNameSb=new StringBuilder();
			    }  
		    	if (tagName.equalsIgnoreCase("DateOfBirth")) {  
		    		birthdayTag = "open";  
		    		birthdaySb=new StringBuilder();
			    }
		    } 	
		    @Override
			public void characters(char ch[], int start, int length)throws SAXException { 
		    	if (fmlItemTag.equals("open")) {  
		    		if(newFmlItemFlag){
			    		 fmlItem = new FmlItem();
			    		 newFmlItemFlag=false;
			    		 if (eChildInfoTag.equals("open")){
			    			 //is child
			    			 fmlItem.setType("child");
			    		 }
			    		 else{
			    			 fmlItem.setType("spouse");
			    		 }
			    	 }
			    }
		    	if (firstNameTag.equals("open")) {  
				 	 if (firstNameSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				   	            firstNameSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (lastNameTag.equals("open")) {  
				 	 if (lastNameSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				   	            lastNameSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (fatherNameTag.equals("open")) {  
				 	 if (fatherNameSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	fatherNameSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (birthdayTag.equals("open")) {  
				 	 if (birthdaySb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	birthdaySb.append(ch[i]);
				    	    }
				   	    }
			     }
		    }  
		    
		    @Override
			public void endElement(String uri, String localName, String tagName)  
		    	throws SAXException {  
				   	if (tagName.equalsIgnoreCase("item")) {  
				   		fmlItemTag = "close";    
					    newFmlItemFlag=true;
					    fmlItemList.add(fmlItem);
				   	}  
				   	if (tagName.equalsIgnoreCase("firstname")) {  
				   		firstNameTag = "close"; 
				   		fmlItem.setFirstName(firstNameSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("lastname")) {  
				   		lastNameTag = "close";  
				   		fmlItem.setLastName(lastNameSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("fathersname")) {  
				   		fatherNameTag = "close";
				   		fmlItem.setFatherName(fatherNameSb.toString().trim());
				   	}
				   	
				   	if (tagName.equalsIgnoreCase("DateOfBirth")) {  
				   		birthdayTag = "close";
				   		System.out.println("bbb+"+birthdaySb.toString().trim());
				   		fmlItem.setBirthday(birthdaySb.toString().trim());
				   	}
				   	
				   	if (tagName.equalsIgnoreCase("eChildInfo")) {  
				   		eChildInfoTag = "close";
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
	return fmlItemList;
}

}
