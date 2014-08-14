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
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.model.PrsnlItem;
import com.socar.hrsocar.parser.PersonalParser;
//import com.socar.hrsocar.model.PrsnlItem;

public class PersonalActivity extends Activity {

	SharedPreferences sharedPreferences;
	private final String childSpace="- ";
	private String prsnlPernr;
	private String[] tempChildValues;
	private String tempSpouseChildValues[];
	private String prsnlResponse;
	private List<String> groupValues=new ArrayList<String>();
	private List<String[]> childValues=new ArrayList<String[]>();
	private int prsnlItemListSize;
	private List<PrsnlItem> prsnlItemList= new ArrayList<PrsnlItem>();
	private Map<String,String> prsnlParams;
	public static final String prsnlPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	final Context context = this;
	private ExpandableListView expandableListView;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_personal);
		try {
			prsnlParams= new HashMap <String,String>();
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			prsnlPernr=sharedPreferences.getString(prsnlPernrKey, null);
			prsnlParams.put("url", Parameters.getPrsnlUrl());
			prsnlParams.put("prsnl_pernr", prsnlPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			prsnlResponse=webserviceRequest.execute(prsnlParams).get();
			PersonalParser disciplinaryParser = new PersonalParser (prsnlResponse);
			prsnlItemList=disciplinaryParser.getResult();
			if (prsnlItemList !=null){
		        for (int i=0;i<prsnlItemList.size();i++){
		        	tempChildValues=new String[5];
		        	tempChildValues[0]=Parameters.getprsnlSerialNumberLabel()+prsnlItemList.get(i).getSerialNumber();
		        	tempChildValues[1]=Parameters.getprsnlIssuanceDateLabel()+prsnlItemList.get(i).getIssuanceDate();
		        	tempChildValues[2]=Parameters.getprsnlIssuingAuthorityLabel()+prsnlItemList.get(i).getIssuingAuthority();
		        	tempChildValues[3]=Parameters.getprsnlExpirationDateLabel()+prsnlItemList.get(i).getExpirationDate();
		        	tempChildValues[4]=Parameters.getprsnlpinCodeLabel()+prsnlItemList.get(i).getPinCode();
		        	childValues.add(tempChildValues);
		        	groupValues.add("Şəxsiyyət Vəsiqəsi");
		        }
		        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
		        expandableListView.setAdapter(new DscpExpandableListAdapter(context, this, childValues,groupValues));
			}
	} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
