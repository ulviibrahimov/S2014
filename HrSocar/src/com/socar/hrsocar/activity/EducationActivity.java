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
import com.socar.hrsocar.model.EdItem;
import com.socar.hrsocar.model.Parameters;
import com.socar.hrsocar.parser.EducationParser;
/**
 * @author ulvi
 * This activity displays user's education information
 */
public class EducationActivity extends Activity {
	SharedPreferences sharedPreferences;
	private String edPernr;
	private String edResponse;
	private List<String> groupValues=new ArrayList<String>();
	private List<String[]> childValues=new ArrayList<String[]>();
	private List<EdItem> edItemList= new ArrayList<EdItem>();
	private Map<String,String> edParams;
	private Integer edItemListSize;
	private String[] tempChildValues;
	public static final String edPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
	final Context context = this;
	private ExpandableListView expandableListView;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_education);
		try {
			edParams= new HashMap <String,String>();
			sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			edPernr=sharedPreferences.getString(edPernrKey, null);
			edParams.put("url", Parameters.getEdUrl());
			edParams.put("ed_pernr", edPernr);
			WebserviceRequest webserviceRequest = new WebserviceRequest ();
			edResponse=webserviceRequest.execute(edParams).get();
			System.out.println("edd"+edResponse);
			EducationParser educationParser = new EducationParser (edResponse);
			edItemList=educationParser.getResult();
			for (int i=0;i<edItemList.size();i++){
				tempChildValues=new String[11];
				tempChildValues[0]=Parameters.getEdBegdaLabel()+edItemList.get(i).getBegda();
				tempChildValues[1]=Parameters.getEdEnddaLabel()+edItemList.get(i).getEndda();
				tempChildValues[2]=Parameters.getEdCountryLabel()+edItemList.get(i).getCountry();
				tempChildValues[3]=Parameters.getEdScientificDegreeLabel()+edItemList.get(i).getScientificDegree();
				tempChildValues[4]=Parameters.getEdEduDegreeLabel()+edItemList.get(i).getEduDegree();
				tempChildValues[5]=Parameters.getEdDocumentTypeLabel()+edItemList.get(i).getDocumentType();
				tempChildValues[6]=Parameters.getEdFinalGradeLabel()+edItemList.get(i).getFinalGrade();
				tempChildValues[7]=Parameters.getEdIstigametLabel()+edItemList.get(i).getIstiqamet();
				tempChildValues[8]=Parameters.getEdMajorLabel()+edItemList.get(i).getMajor();
				tempChildValues[9]=Parameters.getEdEduTypeLabel()+edItemList.get(i).getEduType();
				tempChildValues[10]=Parameters.getEdDipNumLabel()+edItemList.get(i).getDipNum();
	        	childValues.add(tempChildValues);
	        	groupValues.add(edItemList.get(i).getEduInstitution());
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
