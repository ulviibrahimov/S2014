package com.socar.hrsocar.activity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.socar.hrsocar.R;
import com.socar.hrsocar.R.layout;
import com.socar.hrsocar.controller.WebserviceRequest;
import com.socar.hrsocar.model.Parameters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class FamilyActivity extends Activity {

	SharedPreferences sharedPreferences;
	private String fmlPernr;
	private String fmlResponse;
	private Map<String,String> fmlParams;
	public static final String fmlPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_family);
		try {
			fmlParams= new HashMap <String,String>();
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			fmlPernr=sharedPreferences.getString(fmlPernrKey, null);
			fmlParams.put("url", Parameters.getFmlUrl());
			fmlParams.put("fml_pernr", fmlPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			fmlResponse=webserviceRequest.execute(fmlParams).get();
			System.out.println("fmlrr"+fmlResponse);
			//MilitaryParser militaryParser = new MilitaryParser (fmlResponse);
			//fmlItemList=militaryParser.getResult();
			//fmlItemListSize=fmlItemList.size();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
