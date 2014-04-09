package com.example.danceforhealth;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class NewWorkoutActivity extends Activity implements OnItemSelectedListener{

	String selection = "Dance";
	Workout w = new Workout();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_workout);
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.workouts_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}
	
	public void onNextButtonClick(View view) {
			w.setType(selection);
			// create an Intent using the current Activity 
			// and the Class to be created
			Intent i = new Intent(this, RatingActivity.class).putExtra("workout", w);
	
			// pass the Intent to the Activity, 
			// using the specified request code
			startActivity(i);
	}

	
	// figure out how to access string array elements--not just hardcode workouts
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		switch(position) {
		case 0:
			selection = "Dance";
			break;
		case 1:
			selection = "Run";
			break;
		case 2:
			selection = "Walk";
			break;
		case 3:
			selection = "Bike";
			break;
		case 4:
			selection = "Swim";
			break;
		// learn how to allow user to input "other" in dropdown text box
		case 5:
			selection = "Other";
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
