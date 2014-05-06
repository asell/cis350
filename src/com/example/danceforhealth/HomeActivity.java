package com.example.danceforhealth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	private boolean loadApp = true;
	private String file = "data_workout";
	private String data = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		Context context = this;


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

	public static void createDatabase(String data) throws Exception {

		if (data == null || data.equals("")) { return ; }

		PrevWorkout pw = PrevWorkout.getInstance();
		List<Workout> workouts = (ArrayList<Workout>) pw.getPrevious();
		
	//workouts.clear();

		String delims = "\n";
		String[] lines;
		String[] tokens;

		lines = data.split(delims);

		for (String line : lines) {
			String del = ",";
			tokens = line.split(del);

			String type = tokens[0];
			String str = tokens[1];
			int strain = Integer.parseInt(str);
			String heart = tokens[2];
			int hr = Integer.parseInt(heart);
			String st = tokens[3];
			int steps = Integer.parseInt(st);
			String w = tokens[4];
			int weight = Integer.parseInt(w);
			String date = tokens[5]; 
			String timeString = tokens[6];
			int time = Integer.parseInt(timeString);

			Workout wo = new Workout(type, strain, hr, steps, weight);
			wo.setDate(date);
			wo.setTime(time);
			workouts.add(wo);
		}


	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}
		reader.close();

		return sb.toString();
	}


}
