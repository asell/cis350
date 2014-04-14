package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WeightAndStepsActivity extends Activity{
	private int weight;
	private int steps;
	private Workout w;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_and_steps);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    w = (Workout) extras.get("workout");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight_and_steps, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		EditText et1 = (EditText) findViewById(R.id.editText1);
		EditText et2 = (EditText) findViewById(R.id.editText2);
		if(!et1.getText().toString().trim().equals("")) {
			steps = Integer.parseInt(et1.getText().toString());
			w.setSteps(steps);
		}
		if(!et2.getText().toString().trim().equals("")) {
			weight = Integer.parseInt(et2.getText().toString());
			w.setWeight(weight);
		}
		
		
	
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HeartRateActivity.class).putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
}
