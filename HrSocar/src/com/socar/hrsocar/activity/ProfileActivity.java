package com.socar.hrsocar.activity;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.socar.hrsocar.R;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
public class ProfileActivity extends Activity {
	  private ListView mainListView ;
	  private ArrayAdapter<String> listAdapter ;
	  
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_profile); 
	    mainListView = (ListView) findViewById( R.id.mainListView );
	    String[] planets = new String[] { "İşdə olmamaları haqqında məlumat", "Ailə üzvləri haqqında", "İntizam tənbehləri", "Şəxsiyyət vəsiqəsi",
	                                      "Əmək fəaliyyəti haqqında", "Hərbi bilet", "Əmək haqqı", "Məzuniyyət"};  
	    ArrayList<String> planetList = new ArrayList<String>();
	    planetList.addAll( Arrays.asList(planets) );
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
	    mainListView.setAdapter( listAdapter );      
	    mainListView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {
	        	switch(position){
	        	case 2: 
	        		Intent dscpIntent = new Intent(getApplicationContext(), DisciplinaryActivity.class);
					ProfileActivity.this.startActivity(dscpIntent);
					break;
	        	case 5:
	        		Intent mltrIntent = new Intent(getApplicationContext(), MilitaryActivity.class);
					ProfileActivity.this.startActivity(mltrIntent);
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
	    	public void onClick(DialogInterface dialog, int whichButton) {
	    		finish();
	    		System.exit(1);
	    	  }
	    	});
	        	exitAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	    	  public void onClick(DialogInterface dialog, int whichButton) {
	    	    // Canceled.
	    	  }
	    	});

	    	exitAlert.show();
		}	 

}
