package com.socar.hrsocar.activity;

import java.util.ArrayList;
import java.util.Arrays;

import com.socar.hrsocar.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ProfileActivity extends Activity {

	 private ListView mainListView ;
	  private ArrayAdapter<String> listAdapter ;
	  
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_profile);
	    
	  
	    // Find the ListView resource. 
	    mainListView = (ListView) findViewById( R.id.mainListView );

	    // Create and populate a List.
	    String[] planets = new String[] { "İşdə olmamaları haqqında məlumat", "Ailə üzvləri haqqında", "İntizam tənbehləri", "Şəxsiyyət vəsiqəsi",
	                                      "Əmək fəaliyyəti haqqında", "Hərbi bilet", "Əmək haqqı", "Məzuniyyət"};  
	    ArrayList<String> planetList = new ArrayList<String>();
	    planetList.addAll( Arrays.asList(planets) );
	    
	    // Create ArrayAdapter using the  list.
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
	    
	    // Set the ArrayAdapter as the ListView's adapter.
	    mainListView.setAdapter( listAdapter );      
	    
	  }
	 

}
