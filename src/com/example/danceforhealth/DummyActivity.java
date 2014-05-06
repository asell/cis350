package com.example.danceforhealth;
import java.util.List;

import com.example.danceforhealth.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DummyActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy);
		
		
		createWorkout();
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		TextView txt = (TextView) findViewById(R.id.textView1);
		Button b = (Button) findViewById(R.id.preWorkout);
		txt.setTypeface(font);
		b.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dummy, menu);
		return true;
	}

	public void createWorkout() {
		
		String d2 = "Thu 5 1 2014";
		String d3 = "Mon 4 28 2014";
		String d4 = "Sat 4 12 2014";
		String d5 = "Sat 3 15 2014";
		String d6 = "Fri 1 3 2014";
		
		Workout w1 = new Workout("Dance", 10, 180, 500, 130);
		Workout w2 = new Workout("Walk", 10, 180, 500, 140);
		Workout w3 = new Workout("Run", 10, 180, 500, 135);
		Workout w4 = new Workout("Bike", 10, 180, 500, 143);
		Workout w5 = new Workout("Dance", 10, 180, 500, 140);
		Workout w6 = new Workout("Other", 10, 180, 500, 150);
		
		w2.setDate(d2);
		w3.setDate(d3);
		w4.setDate(d4);
		w5.setDate(d5);
		w6.setDate(d6);

		PrevWorkout pw = PrevWorkout.getInstance();
		List<Workout> all = pw.getPrevious();
		
		// add from least to most recent
		all.add(w6);
		all.add(w5);
		all.add(w4);
		all.add(w3);
		all.add(w2);
		all.add(w1);
		
	}
	
	public void onBackButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HomeActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
