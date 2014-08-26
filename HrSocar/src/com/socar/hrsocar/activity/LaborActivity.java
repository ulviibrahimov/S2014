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
import com.socar.hrsocar.parser.LaborParser;
import com.socar.hrsocar.adapter.DscpExpandableListAdapter;
import com.socar.hrsocar.model.LbcItem;
import com.socar.hrsocar.parser.LaborParser;

public class LaborActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String lbcPernr;
	private String lbcResponse;
	private String[] tempChildValues;
	private List<String[]> childValues=new ArrayList<String[]>();
	private List<String> groupValues=new ArrayList<String>();
	private List<String> ExpandableChildren;
	private List<LbcItem> lbcItemList= new ArrayList<LbcItem>();
	private Map<String,String> lbcParams;
	private Map<String,List<String>> lbcAdapterParams;
	private Integer lbcItemListSize;
	public static final String lbcPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
    private ExpandableListView expandableListView;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_labor);
		try {
			lbcParams= new HashMap <String,String>();
			lbcAdapterParams=new HashMap <String,List<String>>(); 
			//TODO change to default preferences
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			lbcPernr=sharedPreferences.getString(lbcPernrKey, null);
			lbcParams.put("url", Parameters.getLbcUrl());
			lbcParams.put("lbc_pernr", lbcPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			lbcResponse=webserviceRequest.execute(lbcParams).get();
			LaborParser disciplinaryParser = new LaborParser (lbcResponse);
			lbcItemList=disciplinaryParser.getResult();
			System.out.println("lll"+lbcItemList.size());
			/*if (lbcItemList !=null){
		        for (int i=0;i<lbcItemList.size();i++){
		        	tempChildValues=new String[3];
		        	tempChildValues[0]=Parameters.getLbcYsubtyLabel()+lbcItemList.get(i).getResult();
		        	tempChildValues[1]=Parameters.getLbcStartDateLabel()+lbcItemList.get(i).getStartDate();
		        	tempChildValues[2]=Parameters.getLbcEndDateLabel()+lbcItemList.get(i).getEndDate();
		        	childValues.add(tempChildValues);
		        	groupValues.add(lbcItemList.get(i).getReason());
		        }
			
			expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
	        expandableListView.setAdapter(new LbcExpandableListAdapter(context, this, childValues,groupValues));
			}*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
