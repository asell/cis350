package com.example.danceforhealth;

import android.app.Activity;
import android.os.Bundle;

public class WeightAndStepsActivity extends Activity{
	private int weight;
	private int steps;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_and_steps);
	}
}
