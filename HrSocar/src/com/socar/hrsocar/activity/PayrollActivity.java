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
//import com.socar.hrsocar.adapter.PyrlExpandableListAdapter;
//import com.socar.hrsocar.model.PyrlItem;
//import com.socar.hrsocar.parser.payrollParser;

public class PayrollActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String pyrlPernr;
	private String pyrlResponse;
	private String[] tempChildValues;
	private List<String[]> childValues=new ArrayList<String[]>();
	private List<String> groupValues=new ArrayList<String>();
	private List<String> ExpandableChildren;
	//private List<PyrlItem> pyrlItemList= new ArrayList<PyrlItem>();
	private Map<String,String> pyrlParams;
	private Map<String,List<String>> pyrlAdapterParams;
	private Integer pyrlItemListSize;
	public static final String pyrlPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
    private ExpandableListView expandableListView;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_payroll);
		try {
			pyrlParams= new HashMap <String,String>();
			pyrlAdapterParams=new HashMap <String,List<String>>(); 
			//TODO change to default preferences
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			pyrlPernr=sharedPreferences.getString(pyrlPernrKey, null);
			pyrlParams.put("url", Parameters.getPyrlUrl());
			pyrlParams.put("pyrl_pernr", pyrlPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			pyrlResponse=webserviceRequest.execute(pyrlParams).get();
			System.out.println("pyrll"+pyrlResponse);
			//payrollParser disciplinaryParser = new payrollParser (pyrlResponse);
			//pyrlItemList=disciplinaryParser.getResult();
			/*if (pyrlItemList !=null){
		        for (int i=0;i<pyrlItemList.size();i++){
		        	tempChildValues=new String[3];
		        	tempChildValues[0]=Parameters.getPyrlYsubtyLabel()+pyrlItemList.get(i).getResult();
		        	tempChildValues[1]=Parameters.getPyrlStartDateLabel()+pyrlItemList.get(i).getStartDate();
		        	tempChildValues[2]=Parameters.getPyrlEndDateLabel()+pyrlItemList.get(i).getEndDate();
		        	childValues.add(tempChildValues);
		        	groupValues.add(pyrlItemList.get(i).getReason());
		        }
			
			expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
	        expandableListView.setAdapter(new PyrlExpandableListAdapter(context, this, childValues,groupValues));
			}*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
