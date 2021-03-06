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
import com.socar.hrsocar.adapter.DscpExpandableListAdapter;
import com.socar.hrsocar.controller.WebserviceRequest;
import com.socar.hrsocar.model.FmlItem;
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.parser.FamilyParser;

public class FamilyActivity extends Activity {

	SharedPreferences sharedPreferences;
	private final String childSpace="- ";
	private String fmlPernr;
	private String[] tempChildValues;
	private String tempSpouseChildValues[];
	private String fmlResponse;
	private List<String> groupValues=new ArrayList<String>();
	private List<String[]> childValues=new ArrayList<String[]>();
	private int fmlItemListSize;
	private List<FmlItem> fmlItemList= new ArrayList<FmlItem>();
	private Map<String,String> fmlParams;
	public static final String fmlPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	final Context context = this;
	private ExpandableListView expandableListView;
	
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
			FamilyParser familyParser = new FamilyParser (fmlResponse);
			fmlItemList = familyParser.getResult();
			fmlItemListSize=fmlItemList.size();
			int x=0;
			int childCount=0;
        	tempChildValues=new String[(fmlItemListSize-1)*5];
			if (fmlItemList !=null){
		        for (int i=0;i<fmlItemListSize;i++){
		        	if (fmlItemList.get(i).getType().equals("spouse")){
		        		tempSpouseChildValues=new String[4];
		        		tempSpouseChildValues[0]=Parameters.getFmlNameLabel()+fmlItemList.get(i).getFirstName();
		        		tempSpouseChildValues[1]=Parameters.getFmlSurnameLabel()+fmlItemList.get(i).getLastName();
		        		tempSpouseChildValues[2]=Parameters.getFmlFatherNameLabel()+fmlItemList.get(i).getFatherName();
		        		tempSpouseChildValues[3]=Parameters.getFmlBirthdayLabel()+fmlItemList.get(i).getBirthday();
		        	}
		        	else{
		        	childCount++;	
		        	tempChildValues[x++]=childCount+".";
		        	tempChildValues[x++]=Parameters.getFmlNameLabel()+fmlItemList.get(i).getFirstName();
		        	tempChildValues[x++]=Parameters.getFmlSurnameLabel()+fmlItemList.get(i).getLastName();
		        	tempChildValues[x++]=Parameters.getFmlFatherNameLabel()+fmlItemList.get(i).getFatherName();
		        	tempChildValues[x++]=Parameters.getFmlBirthdayLabel()+fmlItemList.get(i).getBirthday();
		        	}
		        }
	        	groupValues.add("Həyat yoldaşı");
	        	childValues.add(tempSpouseChildValues);
	        	childValues.add(tempChildValues);
	        	groupValues.add("Uşaqlar");
			}
			
			expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
	        expandableListView.setAdapter(new DscpExpandableListAdapter(context, this, childValues,groupValues));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
