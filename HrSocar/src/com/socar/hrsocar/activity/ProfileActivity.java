package com.socar.hrsocar.activity;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.socar.hrsocar.R;
public class ProfileActivity extends Activity {
	  private ListView mainListView ;
	  private ArrayAdapter<String> listAdapter ;
	  public static final String MyPREFERENCES = "MyPrefs" ;
	  final Context context = this;

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_profile); 
	    mainListView = (ListView) findViewById( R.id.mainListView );
	    String[] planets = new String[] { "İşdə olmamaları haqqında məlumat", "Ailə üzvləri haqqında", "İntizam tənbehləri", "Şəxsiyyət vəsiqəsi",
	                                      "Əmək fəaliyyəti haqqında", "Hərbi bilet", "Təhsil","Əmək haqqı","Sürücülük vəsiqəsi"};  
	    ArrayList<String> planetList = new ArrayList<String>();
	    planetList.addAll( Arrays.asList(planets) );
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
	    mainListView.setAdapter( listAdapter );      
	    mainListView.setOnItemClickListener(new OnItemClickListener() {
	        @Override
			public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {
	        	switch(position){
	        	case 0:
	        		Intent absIntent = new Intent(getApplicationContext(), AbsencesActivity.class);
					ProfileActivity.this.startActivity(absIntent);
					break;
	        	case 1:
	        		Intent fmlIntent = new Intent(getApplicationContext(), FamilyActivity.class);
					ProfileActivity.this.startActivity(fmlIntent);
					break;
	        	case 2: 
	        		Intent dscpIntent = new Intent(getApplicationContext(), DisciplinaryActivity.class);
					ProfileActivity.this.startActivity(dscpIntent);
					break;
	        	case 3: 
	        		Intent prsnlIntent = new Intent(getApplicationContext(), PersonalActivity.class);
					ProfileActivity.this.startActivity(prsnlIntent);
					break;
	        	case 4:
	        		Intent lbcIntent = new Intent(getApplicationContext(), LaborActivity.class);
					ProfileActivity.this.startActivity(lbcIntent);
					break;
	        	case 5:
	        		Intent mltrIntent = new Intent(getApplicationContext(), MilitaryActivity.class);
					ProfileActivity.this.startActivity(mltrIntent);
					break;
	        	case 6:
	        		Intent edIntent = new Intent(getApplicationContext(), EducationActivity.class);
					ProfileActivity.this.startActivity(edIntent);
					break;
	        	case 7:
	        		Intent payIntent = new Intent(getApplicationContext(), PayrollActivity.class);
					ProfileActivity.this.startActivity(payIntent);
					break;
	        	case 8:
	        		Intent lcsIntent = new Intent(getApplicationContext(), LicenseActivity.class);
					ProfileActivity.this.startActivity(lcsIntent);
					break;
					
	        	}
	        }
	    });
	
	  }
	  

		@Override
		public void onBackPressed() {
			AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);

	    	exitAlert.setTitle("Çıxış");
	    	exitAlert.setMessage("Çıxmaq istədiyinizdən əminsinizmi?");
	    	exitAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	    	@Override
			public void onClick(DialogInterface dialog, int whichButton) {
	    		finish();
	    		SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	    		sharedPreferences.edit().clear().commit();
	    		System.exit(1);
	    	  }
	    	});
	        	exitAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	    	  @Override
			public void onClick(DialogInterface dialog, int whichButton) {
	    	    // Canceled.
	    	  }
	    	});

	    	exitAlert.show();
		}	 

}
