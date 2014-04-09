package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorkoutSummary extends Activity{
	
	private Workout workout;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_summary);
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null)
		    workout = b.getParcelable("this is the selected workout");
	}
	
	
	public void onUpdateButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, RatingActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
