package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutSummary extends Activity{

	private Workout workout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_summary);

		Bundle b = this.getIntent().getExtras();
		if(b!=null)

		    workout = (Workout) b.get("workout");
		workout = b.getParcelable("workout");

		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		TextView txt = (TextView) findViewById(R.id.Header);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		txt.setTypeface(font);
		b1.setTypeface(font);
		b2.setTypeface(font);
		
		String feel ;
		
		if (workout.getStrain() < 3) {
			feel = "GREAT";
		} else if (workout.getStrain() < 5) {
			feel = "GOOD";
		} else {
			feel = "OKAY";
		}

		TextView type = (TextView)findViewById(R.id.workoutType);
		type.setText("Your workout was " + workout.getType());
		
		TextView strain = (TextView)findViewById(R.id.workoutRating);
		strain.setText("Overall, you felt " + feel);

		TextView steps = (TextView)findViewById(R.id.workoutSteps);
		steps.setText("You took " + workout.getSteps() + " steps!");

		TextView weight = (TextView)findViewById(R.id.workoutWeight);
		weight.setText("Your weight was " + workout.getWeight());

		TextView hr = (TextView)findViewById(R.id.workoutHR);
		hr.setText("And your heartrate was " + workout.getHR());
		
		TextView length = (TextView)findViewById(R.id.workoutLength);
		length.setText("You worked out for " + workout.getTime() + " minutes.");

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
