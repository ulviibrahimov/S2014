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
	SharedPreferences sharedPreferences;
	private String absPernr;
	private String absResponse;
	private Map<String,String> absParams;
	private Map<String,List<String>> absAdapterParams;
	public static final String absPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
