package com.socar.hrsocar.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

import com.socar.hrsocar.model.Reg;

public class WebserviceRequest extends AsyncTask<String, Void,String> {
	private Reg usrReg;
	private URL regUrl;
	private String urlString;			
	private HttpResponse regResponse;
	public Reg getUsrReg() {
		return usrReg;
	}

	public void setUsrReg(Reg usrReg) {
		this.usrReg = usrReg;
	}

	public URL getRegUrl() {
		return regUrl;
	}

	public String getUrlString() {
		return urlString;
	}



	@Override
	protected String doInBackground(String... params) {
		if (params[0]=="registration"){
			urlString=params[1]+"?reg_email="+params[2]+"&reg_insuirance="+params[3]+
					"&reg_pernr="+params[4]+"&reg_pin="+params[5];
			System.out.println("url:"+urlString);
			HttpClient httpClient = new DefaultHttpClient();  
			HttpGet httpGet = new HttpGet(urlString);
			try {
				regResponse = httpClient.execute(httpGet);
				StatusLine statusLine = regResponse.getStatusLine();
				if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
			        HttpEntity entity = regResponse.getEntity();
			        ByteArrayOutputStream out = new ByteArrayOutputStream();
			        entity.writeTo(out);
			        out.close();
			        String responseStr = out.toString();
					System.out.println("responsestr:"+responseStr);
			        // do something with response 
			    } else {
			        // handle bad response
			    }
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	

	return null;
	}
}