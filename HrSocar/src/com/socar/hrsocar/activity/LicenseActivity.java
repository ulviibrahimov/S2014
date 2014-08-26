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
import com.socar.hrsocar.model.Parameters;
//import com.socar.hrsocar.adapter.LcsExpandableListAdapter;
//import com.socar.hrsocar.model.LcsItem;
//import com.socar.hrsocar.parser.LicenseParser;

public class LicenseActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String lcsPernr;
	private String lcsResponse;
	private String[] tempChildValues;
	private List<String[]> childValues=new ArrayList<String[]>();
	private List<String> groupValues=new ArrayList<String>();
	private List<String> ExpandableChildren;
	//private List<LcsItem> lcsItemList= new ArrayList<LcsItem>();
	private Map<String,String> lcsParams;
	private Map<String,List<String>> lcsAdapterParams;
	private Integer lcsItemListSize;
	public static final String lcsPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
    private ExpandableListView expandableListView;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_license);
		try {
			lcsParams= new HashMap <String,String>();
			lcsAdapterParams=new HashMap <String,List<String>>(); 
			//TODO change to default preferences
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			lcsPernr=sharedPreferences.getString(lcsPernrKey, null);
			lcsParams.put("url", Parameters.getLcsUrl());
			lcsParams.put("lcs_pernr", lcsPernr);
			System.out.println("here");
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			lcsResponse=webserviceRequest.execute(lcsParams).get();
			System.out.println("lcsc:"+lcsResponse);
			//LicenseParser disciplinaryParser = new LicenseParser (lcsResponse);
			//lcsItemList=disciplinaryParser.getResult();
			/*if (lcsItemList !=null){
		        for (int i=0;i<lcsItemList.size();i++){
		        	tempChildValues=new String[3];
		        	tempChildValues[0]=Parameters.getLcsYsubtyLabel()+lcsItemList.get(i).getResult();
		        	tempChildValues[1]=Parameters.getLcsStartDateLabel()+lcsItemList.get(i).getStartDate();
		        	tempChildValues[2]=Parameters.getLcsEndDateLabel()+lcsItemList.get(i).getEndDate();
		        	childValues.add(tempChildValues);
		        	groupValues.add(lcsItemList.get(i).getReason());
		        }
			
			expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
	        expandableListView.setAdapter(new LcsExpandableListAdapter(context, this, childValues,groupValues));
			}*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
