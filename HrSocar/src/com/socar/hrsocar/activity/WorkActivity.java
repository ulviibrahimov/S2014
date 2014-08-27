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
import android.view.Window;
import android.widget.ExpandableListView;

import com.socar.hrsocar.R;
import com.socar.hrsocar.controller.WebserviceRequest;
//import com.socar.hrsocar.model.WrkItem;
import com.socar.hrsocar.model.Parameters;

public class WorkActivity extends Activity {

	SharedPreferences sharedPreferences;
	private final String childSpace="- ";
	private String wrkPernr;
	private String[] tempChildValues;
	private String tempSpouseChildValues[];
	private String wrkResponse;
	private List<String> groupValues=new ArrayList<String>();
	private List<String[]> childValues=new ArrayList<String[]>();
	private int wrkItemListSize;
	//private List<WrkItem> wrkItemList= new ArrayList<WrkItem>();
	private Map<String,String> wrkParams;
	public static final String wrkPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	final Context context = this;
	private ExpandableListView expandableListView;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_work);
		try {
			wrkParams= new HashMap <String,String>();
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			wrkPernr=sharedPreferences.getString(wrkPernrKey, null);
			wrkParams.put("url", Parameters.getWrkUrl());
			System.out.println("urll"+Parameters.getWrkUrl());
			wrkParams.put("wrk_pernr", wrkPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			wrkResponse=webserviceRequest.execute(wrkParams).get();
	} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
