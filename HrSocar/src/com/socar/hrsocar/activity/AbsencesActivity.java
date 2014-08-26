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
//import com.socar.hrsocar.adapter.AbsExpandableListAdapter;
import com.socar.hrsocar.controller.WebserviceRequest;
//import com.socar.hrsocar.model.AbsItem;
import com.socar.hrsocar.model.Parameters;
//import com.socar.hrsocar.parser.AbsencesParser;

/**
 * @author ulvi
 * This activity displays user's absence information
 */
public class AbsencesActivity extends Activity {
	
	//variable declaration
	
	SharedPreferences sharedPreferences;
	private String absPernr;
	private String absResponse;
	private String[] tempChildValues;
	private List<String[]> childValues=new ArrayList<String[]>();
	private List<String> groupValues=new ArrayList<String>();
	private List<String> ExpandableChildren;
	//private List<AbsItem> absItemList= new ArrayList<AbsItem>();
	private Map<String,String> absParams;
	private Map<String,List<String>> absAdapterParams;
	private Integer absItemListSize;
	public static final String absPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
    private ExpandableListView expandableListView;
    
    
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_absences);
		try {
			absParams= new HashMap <String,String>();
			absAdapterParams=new HashMap <String,List<String>>(); 
			//getting shared preferences
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			//getting pernr from the shared preferences
			absPernr=sharedPreferences.getString(absPernrKey, null);
			//adding url parameters to the Map
			absParams.put("url", Parameters.getAbsUrl());
			absParams.put("abs_pernr", absPernr);
			//web service request
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			absResponse=webserviceRequest.execute(absParams).get();
			System.out.println("abss:"+absResponse);
			//parsing the xml file
			//AbsencesParser disciplinaryParser = new AbsencesParser (absResponse);
			//absItemList=disciplinaryParser.getResult();
			/*if (absItemList !=null){
		        for (int i=0;i<absItemList.size();i++){
		        	tempChildValues=new String[3];
		        	tempChildValues[0]=Parameters.getAbsYsubtyLabel()+absItemList.get(i).getResult();
		        	tempChildValues[1]=Parameters.getAbsStartDateLabel()+absItemList.get(i).getStartDate();
		        	tempChildValues[2]=Parameters.getAbsEndDateLabel()+absItemList.get(i).getEndDate();
		        	childValues.add(tempChildValues);
		        	groupValues.add(absItemList.get(i).getReason());
		        }
			
			expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
	        expandableListView.setAdapter(new AbsExpandableListAdapter(context, this, childValues,groupValues));
			}*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
