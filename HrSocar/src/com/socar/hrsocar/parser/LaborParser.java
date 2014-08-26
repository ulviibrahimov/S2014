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
import com.socar.hrsocar.model.EdItem;
import com.socar.hrsocar.model.LbcItem;
import com.socar.hrsocar.model.PrsnlItem;

public class LaborParser extends DefaultHandler{
	private LbcItem lbcItem;
	List<LbcItem> lbcItemList= new ArrayList<LbcItem>();
	protected StringBuilder begdaSb;
	protected StringBuilder enddaSb;
	protected StringBuilder subtySb;
	protected StringBuilder cvtxtSb;
	protected StringBuilder cvtypSb;
	protected StringBuilder duryySb;
	protected StringBuilder durmmSb;
	protected StringBuilder durddSb;
	protected StringBuilder wrkboSb;
	protected StringBuilder wrkopSb;
	protected StringBuilder positSb;
	protected StringBuilder spheres1Sb;
	protected StringBuilder deparSb;
	protected StringBuilder ptextSb;
	protected StringBuilder perskSb;
	protected StringBuilder trfs1Sb;
	boolean newLbcItemFlag=true;
	private String inputXml;
	public LaborParser(String inputXml) {
		super();
		this.inputXml = inputXml; 
	}
		public List<LbcItem> getResult(){
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = saxParserFactory.newSAXParser();
				DefaultHandler defaultHandler = new DefaultHandler(){
				String lbcItemTag="close";  
			    String begdaTag="close";
			    String enddaTag="close";  
			    String subtyTag="close";
			    String cvtypTag="close";
			    String cvtxtTag="close";
			    String duryyTag="close";
			    String durmmTag="close";
			    String durddTag="close";
			    String wrkboTag="close";
			    String wrkopTag="close";
			    String positTag="close";
			    String spheres1Tag="close";
			    String deparTag="close";
			    String ptextTag="close";
			    String perskTag="close";
			    String trfs1Tag="close";
			    public void startElement(String uri, String localName, String tagName,Attributes attributes) throws SAXException {  
			    	if (tagName.equalsIgnoreCase("item")) {  
			    		lbcItemTag = "open";
				    }
			    	if (tagName.equalsIgnoreCase("begda")) {  
			    		begdaTag = "open";
			    		begdaSb=new StringBuilder();
				    }  
			    	
			    	if (tagName.equalsIgnoreCase("endda")) {  
			    		enddaTag = "open";
			    		enddaSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("Subty")) {  
			    		subtyTag = "open";
			    		subtySb=new StringBuilder();
				    }  
			    	if (tagName.equalsIgnoreCase("cvtyp")) {  
			    		cvtypTag = "open";  
			    		cvtypSb=new StringBuilder();
				    }
			    	if (tagName.equalsIgnoreCase("Cvtxt")) {  
			    		cvtxtTag = "open";
			    		cvtxtSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("Duryy")) {  
			    		duryyTag = "open";
			    		duryySb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("Durmm")) {  
			    		durmmTag = "open";
			    		durmmSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("Durdd")) {  
			    		durddTag = "open";
			    		durddSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("Wrkbo")) {  
			    		wrkboTag = "open";
			    		wrkboSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("Wrkop")) {  
			    		wrkopTag = "open";
			    		wrkopSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("posit")) {  
			    		positTag = "open";
			    		positSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("spheres1")) {  
			    		spheres1Tag = "open";
			    		spheres1Sb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("depar")) {  
			    		deparTag = "open";
			    		deparSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("ptext")) {  
			    		ptextTag = "open";
			    		ptextSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("persk")) {  
			    		perskTag = "open";
			    		perskSb=new StringBuilder();
				    } 
			    	if (tagName.equalsIgnoreCase("trfs1")) {  
			    		trfs1Tag = "open";
			    		trfs1Sb=new StringBuilder();
				    } 
			    } 	
			    public void characters(char ch[], int start, int length)throws SAXException { 
			    	if (lbcItemTag.equals("open")) {  
			    		if(newLbcItemFlag){
				    		 lbcItem = new LbcItem();
				    		 newLbcItemFlag=false;
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
			    	if (subtyTag.equals("open")) {  
					 	 if (subtySb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	subtySb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (cvtypTag.equals("open")) {  
					 	 if (cvtypSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	cvtypSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (cvtxtTag.equals("open")) {  
					 	 if (cvtxtSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	cvtxtSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (duryyTag.equals("open")) {  
					 	 if (duryySb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	duryySb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (durmmTag.equals("open")) {  
					 	 if (durmmSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	durmmSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (durddTag.equals("open")) {  
					 	 if (durddSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	durddSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (wrkboTag.equals("open")) {  
					 	 if (wrkboSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	wrkboSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (wrkopTag.equals("open")) {  
					 	 if (wrkopSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	wrkopSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (positTag.equals("open")) {  
					 	 if (positSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	positSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (spheres1Tag.equals("open")) {  
					 	 if (spheres1Sb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	spheres1Sb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (deparTag.equals("open")) {  
					 	 if (deparSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	deparSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (ptextTag.equals("open")) {  
					 	 if (ptextSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	ptextSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (perskTag.equals("open")) {  
					 	 if (perskSb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	perskSb.append(ch[i]);
					    	    }
					   	    }
				     }
			    	if (trfs1Tag.equals("open")) {  
					 	 if (trfs1Sb!=null) {
					 	        for (int i=start; i<start+length; i++) {
					 	        	trfs1Sb.append(ch[i]);
					    	    }
					   	    }
				     }
			    }  
			    
			    public void endElement(String uri, String localName, String tagName)  
			    	throws SAXException {  
					   	if (tagName.equalsIgnoreCase("item")) {  
					   		lbcItemTag = "close";    
						    newLbcItemFlag=true;
						    lbcItemList.add(lbcItem);
					   	}  
					   	if (tagName.equalsIgnoreCase("begda")) {  
					   		begdaTag = "close"; 
					   		lbcItem.setBegda(begdaSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("endda")) {  
					   		enddaTag = "close";  
					   		lbcItem.setEndda(enddaSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("subty")) {  
					   		subtyTag = "close";
					   		lbcItem.setSubty(subtySb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("cvtyp")) {  
					   		cvtypTag = "close";  
					   		lbcItem.setCvtyp(cvtypSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("cvtxt")) {  
					   		cvtxtTag = "close";  
					   		lbcItem.setCvtxt(cvtxtSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("duryy")) {  
					   		duryyTag = "close";  
					   		lbcItem.setDuryy(duryySb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("durmm")) {  
					   		durmmTag = "close";  
					   		lbcItem.setDurmm(durmmSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("durdd")) {  
					   		durddTag = "close";  
					   		lbcItem.setDurdd(durddSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("wrkbo")) {  
					   		wrkboTag = "close";  
					   		lbcItem.setWrkbo(wrkboSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("wrkop")) {  
					   		wrkopTag= "close";  
					   		lbcItem.setWrkop(wrkopSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("posit")) {  
					   		positTag = "close";  
					   		lbcItem.setPosit(positSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("spheres1")) {  
					   		spheres1Tag = "close";  
					   		lbcItem.setSpheres1(spheres1Sb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("depar")) {  
					   		deparTag = "close";  
					   		lbcItem.setPosit(deparSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("ptext")) {  
					   		ptextTag = "close";  
					   		lbcItem.setPtext(ptextSb.toString().trim());
					   	}
					   	if (tagName.equalsIgnoreCase("persk")) {  
					   		perskTag = "close";  
					   		lbcItem.setPersk(perskSb.toString().trim());
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
		return lbcItemList;
	}
}