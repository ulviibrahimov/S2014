package com.socar.hrsocar.activity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.socar.hrsocar.R;
import com.socar.hrsocar.controller.WebserviceRequest;
import com.socar.hrsocar.model.Reg;
import com.socar.hrsocar.parser.LoginParser;
public class LoginActivity extends Activity {
	private EditText tempEmail;
	private EditText tempInsuirance;
	private EditText tempPernr;
	private EditText tempPin;
	private TextView invalidAttempt;
	private Button loginButton;
	private String tempUrl;
	private Reg userObj;
	private String loginResult;
	private Map<String,String> regParams; 
	private String regResponse;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String regPin = "pinKey"; 
	public static final String regPernr = "pernrKey"; 
	public static final String regInsuirance = "insuiranceKey"; 
	public static final String regEmail = "emailKey"; 
	SharedPreferences sharedPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		if (sharedPreferences.contains(regPin) && sharedPreferences.contains(regPernr) | sharedPreferences.contains(regEmail) | !sharedPreferences.contains(regInsuirance)){
			Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
			LoginActivity.this.startActivity(profileIntent);
			finish();
		}
		loginButton=(Button)findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new OnClickListener(){
	        @SuppressWarnings("unchecked")
			@Override
	        public void onClick(View v) {
	    		tempEmail   = (EditText)findViewById(R.id.editTextEmail);
	    		tempInsuirance   = (EditText)findViewById(R.id.editTextInsuirance);
	    		tempPernr   = (EditText)findViewById(R.id.editTextPernr);
	    		tempPin   = (EditText)findViewById(R.id.editTextPin);
	    		invalidAttempt=(TextView)findViewById(R.id.TextViewError);
	    		tempUrl =  "http://192.168.1.192:8585/xml/req1.php";
	    		userObj= new Reg (tempUrl,tempEmail.getText().toString(),tempInsuirance.getText().toString(),tempPernr.getText().toString(),tempPin.getText().toString());
	    		regParams= new HashMap <String,String>();
	    		regParams.put("url", userObj.getRegUrl());
	    		regParams.put("reg_email", userObj.getRegEmail());
	    		regParams.put("reg_insuirance", userObj.getRegInsuirance());
	    		regParams.put("reg_pernr", userObj.getRegPernr());
	    		regParams.put("reg_pin", userObj.getRegPin());
	    		try {
	    			WebserviceRequest webserviceRequest = new WebserviceRequest ();
					regResponse=webserviceRequest.execute(regParams).get();
					LoginParser loginParser = new LoginParser (regResponse);
					loginResult=loginParser.getResult();
					if (loginResult.equals("F")){
						invalidAttempt.setText("Yanlış istifadəçi");
						invalidAttempt.setTextColor(Color.RED);
					}
					else if (loginResult.equals("T")){
						addPreferences();
						Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
						LoginActivity.this.startActivity(profileIntent);
						finish();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
	        }});
		
	}
	
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }	
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }
    
    private void clear (){
    	if (tempEmail!=null)
    		tempEmail.getText().clear();
    	if (tempInsuirance!=null)
    		tempInsuirance.getText().clear();
    	if (tempPernr!=null)
    		tempPernr.getText().clear();
    	if (tempPin!=null)
    		tempPin.getText().clear();
    	if (invalidAttempt!=null)
    		invalidAttempt.setText("");
    }
    
    private void addPreferences(){
    	String e  = tempEmail.getText().toString();
        String pr  = tempPernr.getText().toString();
        String p  = tempPin.getText().toString();
        String i  = tempInsuirance.getText().toString();
        Editor editor = sharedPreferences.edit();
        editor.putString(regEmail, e);
        editor.putString(regPernr, pr);
        editor.putString(regPin, p);
        editor.putString(regInsuirance, i);
        editor.commit(); 
    }
}
