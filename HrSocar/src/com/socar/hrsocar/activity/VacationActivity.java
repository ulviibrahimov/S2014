package com.socar.hrsocar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.socar.hrsocar.R;

public class VacationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_vacation);
	}
}
