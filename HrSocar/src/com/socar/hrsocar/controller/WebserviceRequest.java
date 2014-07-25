package com.socar.hrsocar.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

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

public class WebserviceRequest extends AsyncTask<Map<String,String>, String,String> {
	private Reg usrReg;
	private URL regUrl;
	private String urlString;
	private String responseStr;
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
	protected String doInBackground(Map<String,String>... params) {
		
		urlString=params[0].get("url")+"?";
		for ( String key : params[0].keySet() ) {
			if(key!="url"){
				urlString=urlString+key+"="+params[0].get(key)+"&";
			}
		}
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
			        responseStr = out.toString();
			    } else {
			    }
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	return responseStr;
	}
	
	@Override
    protected void onPostExecute(String result) {
		super.onPostExecute(result);
        }
}