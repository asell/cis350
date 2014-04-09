package com.example.danceforhealth;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HeartRateActivity extends Activity {
	private int weight;
	private int steps;
	private String workoutType;
	private int heartrate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heart_rate);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    workoutType = extras.getString("workoutType");
		    weight = extras.getInt("weight");
		    steps = extras.getInt("steps");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heart_rate, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, WorkoutSummary.class).putExtra("workoutType", workoutType).putExtra("weight", weight).putExtra("steps", steps).putExtra("heartrate", heartrate);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
