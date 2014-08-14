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
import com.socar.hrsocar.model.MltrItem;
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.parser.MilitaryParser;

public class MilitaryActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String mltrPernr;
	private String mltrResponse;
	private List<String> groupValues=new ArrayList<String>();
	private List<String[]> childValues=new ArrayList<String[]>();
	private List<MltrItem> mltrItemList= new ArrayList<MltrItem>();
	private Map<String,String> mltrParams;
	private Integer mltrItemListSize;
	private String[] tempChildValues;
	public static final String mltrPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	final Context context = this;
	private ExpandableListView expandableListView;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_military);
		try {
			mltrParams= new HashMap <String,String>();
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			mltrPernr=sharedPreferences.getString(mltrPernrKey, null);
			mltrParams.put("url", Parameters.getMltrUrl());
			mltrParams.put("mltr_pernr", mltrPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			mltrResponse=webserviceRequest.execute(mltrParams).get();
			MilitaryParser militaryParser = new MilitaryParser (mltrResponse);
			mltrItemList=militaryParser.getResult();
			for (int i=0;i<mltrItemList.size();i++){
				tempChildValues=new String[9];
				tempChildValues[0]=Parameters.getMltrSeriesLabel()+mltrItemList.get(i).getSeries();
				tempChildValues[1]=Parameters.getMltrIdNumberLabel()+mltrItemList.get(i).getIdNumber();
				tempChildValues[2]=Parameters.getMltrIssueDateLabel()+mltrItemList.get(i).getIssueDate();
				tempChildValues[3]=Parameters.getMltrExpiryDateLabel()+mltrItemList.get(i).getExpiryDate();
				tempChildValues[4]=Parameters.getMltrFitLabel()+mltrItemList.get(i).getFit();
				tempChildValues[5]=Parameters.getMltrGroupLabel()+mltrItemList.get(i).getGroup();
				tempChildValues[6]=Parameters.getMltrCategoryLabel()+mltrItemList.get(i).getCategory();
				tempChildValues[7]=Parameters.getMltrStaffLabel()+mltrItemList.get(i).getStaff();
				tempChildValues[8]=Parameters.getMltrRankLabel()+mltrItemList.get(i).getRank();
	        	childValues.add(tempChildValues);
	        	groupValues.add("Hərbi bilet");
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
