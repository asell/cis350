package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WeightAndStepsActivity extends Activity{
	private int weight;
	private int steps;
	private String workoutType;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_and_steps);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    workoutType = extras.getString("workoutType");
		}
	}
	
	public void onNextButtonClick(View view) {
	
			// create an Intent using the current Activity 
			// and the Class to be created
			Intent i = new Intent(this, HeartRateActivity.class).putExtra("workoutType", workoutType)
					.putExtra("weight", weight).putExtra("steps", steps);
	
			// pass the Intent to the Activity, 
			// using the specified request code
			startActivity(i);
	}
}
