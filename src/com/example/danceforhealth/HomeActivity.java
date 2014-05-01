package com.example.danceforhealth;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		// set fonts
		TextView txt = (TextView) findViewById(R.id.custom_font);
		Button btn = (Button) findViewById(R.id.newWorkout);
		Button pw = (Button) findViewById(R.id.preWorkout);
		Button d = (Button) findViewById(R.id.dummy);
		Button pr = (Button) findViewById(R.id.progress);
		Typeface font = Typeface.createFromAsset(getAssets(), "KOMIKAX_.ttf");
		Typeface font_two = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		txt.setTypeface(font);
		btn.setTypeface(font_two);
		pw.setTypeface(font_two);
		d.setTypeface(font_two);
		pr.setTypeface(font_two);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	public void onNewButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, NewWorkoutActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

	public void onPrevButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, PrevWorkoutActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	public void onProgressButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, GraphActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	public void onDummyClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, DummyActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	
	// calculates the level that the person is currently at
	public int calculateLevelByHours() {
		PrevWorkout pws = PrevWorkout.getInstance();
		int sum = 0;
		for(Workout w:pws.getPrevious()) {
			sum += w.getTime();
		}
		// level up every time you reach another ten hours
		int level = sum/600;
		return level;
	}

}
