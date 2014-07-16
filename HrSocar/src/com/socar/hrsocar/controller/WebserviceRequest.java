package com.socar.hrsocar.controller;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.socar.hrsocar.model.Reg;

public class WebserviceRequest {
	private Reg usrReg;
	private URL regUrl;
	private String urlString;
	public WebserviceRequest(Reg usrReg) {
		super();
		this.usrReg = usrReg;
	}
	
	public void makeRequest() {
		try {
			urlString=usrReg.getRegUrl()+"?reg_email="+usrReg.getRegEmail()+"&reg_insuirance="+usrReg.getRegInsuirance()+
										"&reg_pernr="+usrReg.getRegPernr()+"&reg_pin="+usrReg.getRegPin();
			regUrl=new URL (urlString);
			HttpURLConnection  connection = (HttpURLConnection) regUrl.openConnection();
	        connection = (HttpURLConnection) regUrl.openConnection();
	        System.out.println("testtest:"+urlString);
	        java.io.InputStream is  = connection.getInputStream();
	        InputStreamReader reader = new InputStreamReader(is, "utf-8");

	        StringWriter sw = new StringWriter();

	        char [] buffer = new char[1024 * 8];
	        int count ;

	        while( (count = reader.read(buffer)) != -1){
	          sw.write(buffer, 0, count);
	        }

	        System.out.println(sw.toString());
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	      }

	public Reg getUsrReg() {
		return usrReg;
	}

	public void setUsrReg(Reg usrReg) {
		this.usrReg = usrReg;
	}

	public URL getRegUrl() {
		return regUrl;
	}

	public void setRegUrl(URL regUrl) {
		this.regUrl = regUrl;
	}

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
		
	}