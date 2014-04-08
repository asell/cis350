package com.example.danceforhealth;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewWorkoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_workout);
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.workouts_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_workout, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, RatingActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
