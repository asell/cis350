package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RatingActivity extends Activity{
	private String workoutType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    workoutType = extras.getString("workoutType");
		}
	}
	
	public void onNextButtonClick(View view) {
		
			// create an Intent using the current Activity 
			// and the Class to be created
			Intent i = new Intent(this, WeightAndStepsActivity.class).putExtra("workoutType", workoutType);
	
			// pass the Intent to the Activity, 
			// using the specified request code
			startActivity(i);
		
	}
}
