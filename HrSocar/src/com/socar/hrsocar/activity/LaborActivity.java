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
			if (lbcItemList !=null){
		        for (int i=0;i<lbcItemList.size();i++){
		        	tempChildValues=new String[16];
		        	tempChildValues[0]=Parameters.getLbcSubtyLabel()+lbcItemList.get(i).getSubty();
		        	tempChildValues[1]=Parameters.getLbcBegdaLabel()+lbcItemList.get(i).getBegda();
		        	tempChildValues[2]=Parameters.getLbcEnddaLabel()+lbcItemList.get(i).getEndda();
		        	tempChildValues[3]=Parameters.getLbcCvtxtLabel()+lbcItemList.get(i).getCvtxt();
		        	tempChildValues[4]=Parameters.getLbcCvtypLabel()+lbcItemList.get(i).getCvtyp();
		        	tempChildValues[5]=Parameters.getLbcDeparLabel()+lbcItemList.get(i).getDepar();
		        	tempChildValues[6]=Parameters.getLbcDurddLabel()+lbcItemList.get(i).getDurdd();
		        	tempChildValues[7]=Parameters.getLbcDurmmLabel()+lbcItemList.get(i).getDurmm();
		        	tempChildValues[8]=Parameters.getLbcDuryyLabel()+lbcItemList.get(i).getDuryy();
		        	tempChildValues[9]=Parameters.getLbcPerskLabel()+lbcItemList.get(i).getPresk();
		        	tempChildValues[10]=Parameters.getLbcPositLabel()+lbcItemList.get(i).getPosit();
		        	tempChildValues[11]=Parameters.getLbcPtextLabel()+lbcItemList.get(i).getPtext();
		        	tempChildValues[12]=Parameters.getLbcTrfs1Label()+lbcItemList.get(i).getTrfs1();
		        	tempChildValues[13]=Parameters.getLbcwrkboLabel()+lbcItemList.get(i).getWrkbo();
		        	tempChildValues[14]=Parameters.getLbcwrkopLabel()+lbcItemList.get(i).getWrkop();
		        	childValues.add(tempChildValues);
		        	groupValues.add(lbcItemList.get(i).getSpheres1());
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
