package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
		
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		TextView tv3 = (TextView) findViewById(R.id.textView3);
		TextView tv4 = (TextView) findViewById(R.id.textView4);
		TextView tv5 = (TextView) findViewById(R.id.textView5);
		TextView tv6 = (TextView) findViewById(R.id.textView6);
		Button b = (Button) findViewById(R.id.button1);
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		tv1.setTypeface(font);
		tv2.setTypeface(font);
		tv3.setTypeface(font);
		tv4.setTypeface(font);
		tv5.setTypeface(font);
		tv6.setTypeface(font);
		b.setTypeface(font);
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
			w.setStrain(0); // temporary until we have an algorithm for this
			Intent i = new Intent(this, WeightAndStepsActivity.class).putExtra("workout", w);
	
			// pass the Intent to the Activity, 
			// using the specified request code
			startActivity(i);
		
	}
	public void onBackButtonClick(View view) {
		
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, NewWorkoutActivity.class).putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
}
}
