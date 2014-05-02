package com.example.danceforhealth;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeartRateActivity extends Activity {
	
	private Workout w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heart_rate);
		
		Bundle extras = getIntent().getExtras();
 		if (extras != null) {
 		    w = (Workout) extras.get("workout");
 		}
 		

		TextView txt = (TextView) findViewById(R.id.custom_font_two);
		TextView txt1 = (TextView) findViewById(R.id.textView1);
		Button b = (Button) findViewById(R.id.button1);
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		txt.setTypeface(font);
		txt1.setTypeface(font);
		b.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heart_rate, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HeartRateTwo.class).putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
public void onBackButtonClick(View view) {
		
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, WeightAndStepsActivity.class).putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
