package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class RatingActivity extends Activity{
	private Workout w;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    w = (Workout) extras.get("workout");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rating, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		
			// create an Intent using the current Activity 
			// and the Class to be created
			Intent i = new Intent(this, WeightAndStepsActivity.class).putExtra("workout", w);
	
			// pass the Intent to the Activity, 
			// using the specified request code
			startActivity(i);
		
	}
}
