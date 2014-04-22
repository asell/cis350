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
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_summary);
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null)
		    workout = b.getParcelable("this is the selected workout");
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		TextView txt = (TextView) findViewById(R.id.textView1);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		txt.setTypeface(font);
		b1.setTypeface(font);
		b2.setTypeface(font);
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
