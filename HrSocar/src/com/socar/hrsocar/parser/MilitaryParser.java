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

import com.socar.hrsocar.model.MltrItem;
public class MilitaryParser extends DefaultHandler{
	private MltrItem mltrItem;
	List<MltrItem> mltrItemList= new ArrayList<MltrItem>();
	protected StringBuilder seriesSb;
	protected StringBuilder idNumberSb;
	protected StringBuilder issueDateSb;
	protected StringBuilder expiryDateSb;
	protected StringBuilder fitSb;
	protected StringBuilder groupSb;
	protected StringBuilder categorySb;
	protected StringBuilder staffSb;
	protected StringBuilder rankSb;
	boolean newMltrItemFlag=true;
	private String inputXml;
	
	public MilitaryParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
	
	public List<MltrItem> getResult(){
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = saxParserFactory.newSAXParser();
			DefaultHandler defaultHandler = new DefaultHandler(){
			String mltrItemTag="close";  
		    String seriesTag="close";
		    String idNumberTag="close";  
		    String expiryDateTag="close";
		    String issueDateTag="close";
		    String fitTag="close";
		    String groupTag="close";
		    String staffTag="close";
		    String categoryTag="close";
		    String rankTag="close";
		    String eMilitaryInfoTag="close";
		    String educationInfoTag="close";
		    @Override
			public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
		    	
		    	if (tagName.equalsIgnoreCase("EMilitaryInfo")) {  
		    		eMilitaryInfoTag = "open";
			    }  
		    	if (tagName.equalsIgnoreCase("EducationInfo")) {  
		    		educationInfoTag = "open";
			    }  
		    	if (tagName.equalsIgnoreCase("item") && educationInfoTag.equals("close")) {  
		    		System.out.println("here");
		    		mltrItemTag = "open";
			    } 
		    	if (tagName.equalsIgnoreCase("series")) {  
		    		seriesTag = "open";
		    		seriesSb=new StringBuilder();
			    }  
		    	
		    	if (tagName.equalsIgnoreCase("idNumber")) {  
		    		idNumberTag = "open";
		    		idNumberSb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("issueDate")) {  
		    		issueDateTag = "open";
		    		issueDateSb=new StringBuilder();
			    }  
		    	if (tagName.equalsIgnoreCase("ExpiryDate")) {  
		    		expiryDateTag = "open";  
		    		expiryDateSb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("Fit")) {  
		    		fitTag = "open";  
		    		fitSb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("Group")) {  
		    		groupTag = "open";  
		    		groupSb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("Category")) {  
		    		categoryTag = "open";  
		    		categorySb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("Staff")) {  
		    		staffTag = "open";  
		    		staffSb=new StringBuilder();
			    }
		    	if (tagName.equalsIgnoreCase("rank")) {  
		    		rankTag = "open";  
		    		rankSb=new StringBuilder();
			    }
		    } 	
		    @Override
			public void characters(char ch[], int start, int length)throws SAXException { 
		    	if (mltrItemTag.equals("open")) {  
		    		if(newMltrItemFlag){
			    		 mltrItem = new MltrItem();
			    		 newMltrItemFlag=false;
			    	 }
			    }
		    	if (seriesTag.equals("open")) {  
				 	 if (seriesSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				   	            seriesSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (idNumberTag.equals("open")) {  
				 	 if (idNumberSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				   	            idNumberSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (issueDateTag.equals("open")) {  
				 	 if (issueDateSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	issueDateSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (expiryDateTag.equals("open")) {  
				 	 if (expiryDateSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	expiryDateSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (fitTag.equals("open")) {  
				 	 if (fitSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	fitSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (groupTag.equals("open")) {  
				 	 if (groupSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	groupSb.append(ch[i]);
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
		    	
		    	if (staffTag.equals("open")) {  
				 	 if (staffSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	staffSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    	if (rankTag.equals("open")) {  
				 	 if (rankSb!=null) {
				 	        for (int i=start; i<start+length; i++) {
				 	        	rankSb.append(ch[i]);
				    	    }
				   	    }
			     }
		    }  
		    
		    @Override
			public void endElement(String uri, String localName, String tagName)  
		    	throws SAXException {  
				   	if (tagName.equalsIgnoreCase("item") && eMilitaryInfoTag.equals("open") && educationInfoTag.equals("close")) {  
				   		mltrItemTag = "close";    
					    newMltrItemFlag=true;
					    mltrItemList.add(mltrItem);
				   	}  
				   	if (tagName.equalsIgnoreCase("EMilitaryInfo")) {  
				   		eMilitaryInfoTag = "close"; 
				   	}
				   	if (tagName.equalsIgnoreCase("EducationInfo")) {  
				   		educationInfoTag = "close"; 
				   	}
				   	if (tagName.equalsIgnoreCase("series")) {  
				   		seriesTag = "close"; 
				   		mltrItem.setSeries(seriesSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("idNumber")) {  
				   		idNumberTag = "close";  
				   		mltrItem.setIdNumber(idNumberSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("issueDate")) {  
				   		issueDateTag = "close";
				   		mltrItem.setIssueDate(issueDateSb.toString().trim());
				   	}
				   	
				   	if (tagName.equalsIgnoreCase("ExpiryDate")) {  
				   		expiryDateTag = "close";
				   		mltrItem.setExpiryDate(expiryDateSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("fit")) {  
				   		fitTag = "close"; 
				   		mltrItem.setFit(fitSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("group")) {  
				   		groupTag = "close";  
				   		mltrItem.setGroup(groupSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("category")) {  
				   		categoryTag = "close";
				   		mltrItem.setCategory(categorySb.toString().trim());
				   	}
				   	
				   	if (tagName.equalsIgnoreCase("staff")) {  
				   		staffTag = "close";
				   		mltrItem.setStaff(staffSb.toString().trim());
				   	}
				   	if (tagName.equalsIgnoreCase("rank")) {  
				   		rankTag = "close";
				   		mltrItem.setRank(rankSb.toString().trim());
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
	return mltrItemList;
}

}
