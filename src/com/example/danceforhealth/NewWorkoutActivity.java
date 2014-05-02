package com.example.danceforhealth;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewWorkoutActivity extends Activity implements OnItemSelectedListener{

	public String selection;
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
		if(!w.getType().equals("")) {
			setSpinnerSelection(w.getType(), spinner);
		}
		EditText et = (EditText) findViewById(R.id.editText1);
		String time = Integer.toString(w.getTime());
		et.setText(time);

		PrevWorkout pw = PrevWorkout.getInstance();
		List<Workout> all = pw.getPrevious();
		all.add(w);
		selection = "Dance";

		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		Button b = (Button) findViewById(R.id.button1);
		b.setTypeface(font);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_workout, menu);
		return true;
	}
	
	
	public void onNextButtonClick(View view) {
		
		EditText et = (EditText) findViewById(R.id.editText1);
		int time = Integer.parseInt(et.getText().toString());
		w.setType(selection);
		w.setTime(time);
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
		}
		
	}
	
	public void setSpinnerSelection(String type, Spinner sp) {
		if(type.equals("Dance")) {
			sp.setSelection(0);
		}
		else if(type.equals("Run")) {
			sp.setSelection(1);
		}
		else if(type.equals("Walk")) {
			sp.setSelection(2);
		}
		else if(type.equals("Bike")) {
			sp.setSelection(3);
		}
		else if(type.equals("Swim")) {
			sp.setSelection(4);
		}
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	}
	


}
