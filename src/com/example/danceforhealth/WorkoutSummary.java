package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class WorkoutSummary extends Activity{
	
	private Workout workout;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_summary);
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null)
		    workout = (Workout) b.get("workout");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.workout_summary, menu);
		return true;
	}

	
	
	public void onUpdateButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, NewWorkoutActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	
	public void onHomeClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HomeActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
