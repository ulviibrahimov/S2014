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

import com.socar.hrsocar.model.EdItem;

public class EducationParser extends DefaultHandler{
	private EdItem edItem;
	List<EdItem> edItemList= new ArrayList<EdItem>();
	protected StringBuilder begdaSb;
	protected StringBuilder enddaSb;
	protected StringBuilder countrySb;
	protected StringBuilder scientificDegreeSb;
	protected StringBuilder eduDegreeSb;
	protected StringBuilder documentTypeSb;
	protected StringBuilder finalGradeSb;
	protected StringBuilder eduInstitutionSb;
	protected StringBuilder istiqametSb;
	protected StringBuilder majorSb;
	protected StringBuilder eduTypeSb;
	protected StringBuilder dipnumSb;
	boolean newEdItemFlag=true;
	private String inputXml;
	public EducationParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
		public List<EdItem> getResult(){
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = saxParserFactory.newSAXParser();
				DefaultHandler defaultHandler = new DefaultHandler(){
				String edItemTag="close";  
			    String begdaTag="close";
			    String enddaTag="close";  
			    String countryTag="close";
			    String scientificTag="close";
			    String eduDegreeTag="close";
			    String documentTypeTag="close";
			    String finalGradeTag="close";
			    String eduInstitutionTag="close";
			    String istiqametTag="close";
			    String majorTag="close";
			    String eduTypeTag="close";
			    String dipnumTag="close";
			    @Override
				public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
			    	if (tagName.equalsIgnoreCase("item")) {  
			    		edItemTag = "open";
				    }
			    	if (tagName.equalsIgnoreCase("begda")) {  
			    		begdaTag = "open";
			    		begdaSb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("endda")) {  
			    		enddaTag = "open";
			    		enddaSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("country")) {  
			    		countryTag = "open";
			    		countrySb=new StringBuilder();
				    }  
			    	if (tagName.equalsIgnoreCase("scientificdegree")) {  
			    		scientificTag = "open";  
			    		scientificDegreeSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("eduDegree")) {  
			    		eduDegreeTag = "open";
			    		eduDegreeSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("DocumentType")) {  
			    		documentTypeTag = "open";
			    		documentTypeSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("FinalGrade")) {  
			    		finalGradeTag = "open";
			    		finalGradeSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("EduInstitution")) {  
			    		eduInstitutionTag = "open";
			    		eduInstitutionSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("Istiqamet")) {  
			    		istiqametTag = "open";
			    		istiqametSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("major")) {  
			    		majorTag = "open";
			    		majorSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("eduType")) {  
			    		eduTypeTag = "open";
			    		eduTypeSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("dipnum")) {  
			    		dipnumTag = "open";
			    		dipnumSb=new StringBuilder();
				    } 
			    } 	
			    @Override
				public void characters(char ch[], int start, int length)throws SAXException { 
			    	if (edItemTag.equals("open")) {  
			    		if(newEdItemFlag){
				    		 edItem = new EdItem();
				    		 newEdItemFlag=false;
				    	 }
				    }
			    	if (begdaTag.equals("open")) {  
					 	 if (begdaSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					   	            begdaSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (enddaTag.equals("open")) {  
					 	 if (enddaSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					   	            enddaSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (countryTag.equals("open")) {  
					 	 if (countrySb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	countrySb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (scientificTag.equals("open")) {  
					 	 if (scientificDegreeSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	scientificDegreeSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (eduDegreeTag.equals("open")) {  
					 	 if (eduDegreeSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	eduDegreeSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (documentTypeTag.equals("open")) {  
					 	 if (documentTypeSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	documentTypeSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (finalGradeTag.equals("open")) {  
					 	 if (finalGradeSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	finalGradeSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (eduInstitutionTag.equals("open")) {  
					 	 if (eduInstitutionSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	eduInstitutionSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (istiqametTag.equals("open")) {  
					 	 if (istiqametSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	istiqametSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (majorTag.equals("open")) {  
					 	 if (majorSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	majorSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (eduTypeTag.equals("open")) {  
					 	 if (eduTypeSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	eduTypeSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (dipnumTag.equals("open")) {  
					 	 if (dipnumSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	dipnumSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    }  
			    
			    @Override
				public void endElement(String uri, String localName, String tagName)  
			    	throws SAXException {  
					   	if (tagName.equalsIgnoreCase("item")) {  
					   		edItemTag = "close";    
						    newEdItemFlag=true;
						    edItemList.add(edItem);
					   	}  
					   	if (tagName.equalsIgnoreCase("begda")) {  
					   		begdaTag = "close"; 
					   		edItem.setBegda(begdaSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("endda")) {  
					   		enddaTag = "close";  
					   		edItem.setEndda(enddaSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("country")) {  
					   		countryTag = "close";
					   		edItem.setCountry(countrySb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ScientificDegree")) {  
					   		scientificTag = "close";  
					   		edItem.setScientificDegree(scientificDegreeSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("eduDegree")) {  
					   		eduDegreeTag = "close";  
					   		edItem.setEduDegree(eduDegreeSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("documentType")) {  
					   		documentTypeTag = "close";  
					   		edItem.setDocumentType(documentTypeSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("finalGrade")) {  
					   		finalGradeTag = "close";  
					   		edItem.setFinalGrade(finalGradeSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("eduInstitution")) {  
					   		eduInstitutionTag = "close";  
					   		edItem.setEduInstitution(eduInstitutionSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("istiqamet")) {  
					   		istiqametTag = "close";  
					   		edItem.setIstiqamet(istiqametSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("major")) {  
					   		majorTag = "close";  
					   		edItem.setMajor(majorSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("eduType")) {  
					   		eduTypeTag = "close";  
					   		edItem.setEduType(eduTypeSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("dipnum")) {  
					   		dipnumTag = "close";  
					   		edItem.setDipNum(dipnumSb.toString().trim());
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
		return edItemList;
	}
}