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
import com.socar.hrsocar.model.DscpItem;
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.parser.DisciplinaryParser;

public class DisciplinaryActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String dscpPernr;
	private String dscpResponse;
	private List<String> ExpandableChildren;
	private List<DscpItem> dscpItemList= new ArrayList<DscpItem>();
	private Map<String,String> dscpParams;
	private Map<String,List<String>> dscpAdapterParams;
	private Integer dscpItemListSize;
	public static final String dscpPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
    private static final String[][] data = {{"audia4","audiq7","audir8"},{"bmwm6","bmwx6"},{"ferrarienzo","ferrarif430","ferrarif430italia"}};
    private ExpandableListView expandableListView;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_disciplinary);
		try {
			dscpParams= new HashMap <String,String>();
			dscpAdapterParams=new HashMap <String,List<String>>(); 
			//TODO change to default preferences
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			dscpPernr=sharedPreferences.getString(dscpPernrKey, null);
			dscpParams.put("url", Parameters.getDscpUrl());
			dscpParams.put("dscp_pernr", dscpPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			dscpResponse=webserviceRequest.execute(dscpParams).get();
			DisciplinaryParser disciplinaryParser = new DisciplinaryParser (dscpResponse);
			dscpItemList=disciplinaryParser.getResult();
			expandableListView = (ExpandableListView)findViewById(R.id.expandableListView1);
	        expandableListView.setAdapter(new DscpExpandableListAdapter(context, this, dscpItemList));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
