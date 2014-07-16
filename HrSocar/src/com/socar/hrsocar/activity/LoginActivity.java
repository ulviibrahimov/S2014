package com.socar.hrsocar.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.socar.hrsocar.R;
import com.socar.hrsocar.controller.WebserviceRequest;
import com.socar.hrsocar.model.Reg;
public class LoginActivity extends Activity {
	private EditText tempEmail;
	private EditText tempInsuirance;
	private EditText tempPernr;
	private EditText tempPin;
	private Button loginButton;
	private String tempUrl;
	private Reg userObj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		loginButton=(Button)findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new OnClickListener(){
	        @Override
	        public void onClick(View v) {
	    		tempEmail   = (EditText)findViewById(R.id.editTextEmail);
	    		tempInsuirance   = (EditText)findViewById(R.id.editTextInsuirance);
	    		tempPernr   = (EditText)findViewById(R.id.editTextPernr);
	    		tempPin   = (EditText)findViewById(R.id.editTextPin);
	    		tempUrl =  "http://192.168.1.192:8585/xml/req1.php";
	    		userObj= new Reg (tempUrl,tempEmail.getText().toString(),tempInsuirance.getText().toString(),tempPernr.getText().toString(),tempPin.getText().toString());
	    		WebserviceRequest aTask = new WebserviceRequest ();
	        	aTask.execute("registration",userObj.getRegUrl(),userObj.getRegEmail(),userObj.getRegInsuirance(),userObj.getRegPernr(),userObj.getRegPin());
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
}
