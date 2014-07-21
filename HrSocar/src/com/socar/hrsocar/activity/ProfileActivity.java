package com.socar.hrsocar.activity;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.socar.hrsocar.R;


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
	    
	  }
	 

}
