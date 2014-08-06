package com.socar.hrsocar.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.socar.hrsocar.R;
import com.socar.hrsocar.R.layout;
import com.socar.hrsocar.controller.WebserviceRequest;
//import com.socar.hrsocar.model.mltrItem;
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.parser.DisciplinaryParser;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MilitaryActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String mltrPernr;
	private String mltrResponse;
	//private List<mltrItem> mltrItemList= new ArrayList<mltrItem>();
	private Map<String,String> mltrParams;
	private Integer mltrItemListSize;
	public static final String mltrPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	
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
			System.out.println("mltrrr"+mltrResponse);
			//MilitaryParser disciplinaryParser = new MilitaryParser (mltrResponse);
			//mltrItemList=disciplinaryParser.getResult();
			//mltrItemListSize=mltrItemList.size();
			final TextView[] mltrTextViews = new TextView[mltrItemListSize];
			for(int i=0;i<mltrItemListSize;i++){
				final TextView rowTextView = new TextView(this);
				//rowTextView.setText(mltrItemList.get(i).getReason());
				LinearLayout ll3 = (LinearLayout) this.findViewById(R.id.ll3);
				ll3.addView(rowTextView);
				mltrTextViews[i]=rowTextView;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}