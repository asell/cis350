package com.example.danceforhealth;

import android.app.Activity;
import android.os.Bundle;

public class RatingActivity extends Activity{
	String workoutType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    workoutType = extras.getString("workoutType");
		}
	}
}
