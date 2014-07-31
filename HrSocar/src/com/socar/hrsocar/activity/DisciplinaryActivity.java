package com.socar.hrsocar.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.socar.hrsocar.R;
import com.socar.hrsocar.controller.WebserviceRequest;
import com.socar.hrsocar.model.DscpItem;
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.parser.DisciplinaryParser;
import com.socar.hrsocar.parser.LoginParser;

public class DisciplinaryActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String dscpPernr;
	private String dscpResponse;
	private List<DscpItem> dscpItemList= new ArrayList<DscpItem>();
	private Map<String,String> dscpParams;
	public static final String dscpPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_disciplinary);
		try {
			dscpParams= new HashMap <String,String>();
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			dscpPernr=sharedPreferences.getString(dscpPernrKey, null);
			dscpParams.put("url", Parameters.getDscpUrl());
			dscpParams.put("dscp_pernr", dscpPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			dscpResponse=webserviceRequest.execute(dscpParams).get();
			DisciplinaryParser disciplinaryParser = new DisciplinaryParser (dscpResponse);
			dscpItemList=disciplinaryParser.getResult();
			System.out.println("item1:"+dscpItemList.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
