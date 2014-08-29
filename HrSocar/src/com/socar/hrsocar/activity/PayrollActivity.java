package com.socar.hrsocar.activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;
import com.socar.hrsocar.R;
public class PayrollActivity extends FragmentActivity {
	SharedPreferences sharedPreferences;
	public static final String pyrlPernrKey = "pernrKey"; 
	public static final String MyPREFERENCES = "MyPrefs" ;
    final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_payroll);
	    TextView periodText = (TextView) findViewById(R.id.textViewPeriod);
	    periodText.setText("Ay seçin");
	    periodText.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        }
	    		});
	}
	
	
	//this method is supposed to return a date Picker dialog without a day field, but it is not used
    private DatePickerDialog createDialogWithoutDateField(){
    DatePickerDialog dpd = new DatePickerDialog(this, null,2014,1, 24);
    try{
    java.lang.reflect.Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
    for (java.lang.reflect.Field datePickerDialogField : datePickerDialogFields) { 
        if (datePickerDialogField.getName().equals("mDatePicker")) {
            datePickerDialogField.setAccessible(true);
            DatePicker datePicker = (DatePicker) datePickerDialogField.get(dpd);
            java.lang.reflect.Field[] datePickerFields = datePickerDialogField.getType().getDeclaredFields();
            for (java.lang.reflect.Field datePickerField : datePickerFields) {
               if ("mDaySpinner".equals(datePickerField.getName())) {
                  datePickerField.setAccessible(true);
                  Object dayPicker = new Object();
                  dayPicker = datePickerField.get(datePicker);
                  ((View) dayPicker).setVisibility(View.GONE);
               }
               if ("mCalendar".equals(datePickerField.getName())) {
                   datePickerField.setAccessible(true);
                   Object calendarPicker = new Object();
                   calendarPicker = datePickerField.get(datePicker);
                   ((View) calendarPicker).setVisibility(View.GONE);
                }
            }
         }

      }
    }catch(Exception ex){
    }
    return dpd;

     }
    

}
