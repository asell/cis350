package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WeightAndStepsActivity extends Activity{
	private int weight;
	private int steps;
	private Workout w;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_and_steps);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    w = (Workout) extras.get("workout");
		}
		
		TextView txt1 = (TextView) findViewById(R.id.textView1);
		EditText etxt1 = (EditText) findViewById(R.id.editText1);
		TextView txt2 = (TextView) findViewById(R.id.textView2);
		EditText etxt2 = (EditText) findViewById(R.id.editText2);
		Button b = (Button) findViewById(R.id.button1);
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		txt1.setTypeface(font);
		etxt1.setTypeface(font);
		txt2.setTypeface(font);
		etxt2.setTypeface(font);
		b.setTypeface(font);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight_and_steps, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		EditText et1 = (EditText) findViewById(R.id.editText1);
		EditText et2 = (EditText) findViewById(R.id.editText2);
		if(!et1.getText().toString().trim().equals("")) {
			steps = Integer.parseInt(et1.getText().toString());
			w.setSteps(steps);
		}
		else {
			w.setSteps(0);
		}
		if(!et2.getText().toString().trim().equals("")) {
			weight = Integer.parseInt(et2.getText().toString());
			w.setWeight(weight);

		}
		else {
			w.setWeight(0);
		}
	
		
	
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HeartRateActivity.class).putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	public void onBackButtonClick(View view) {
		
		EditText et1 = (EditText) findViewById(R.id.editText1);
		EditText et2 = (EditText) findViewById(R.id.editText2);
		if(!et1.getText().toString().trim().equals("")) {
			steps = Integer.parseInt(et1.getText().toString());
			w.setSteps(steps);
		}
		else {
			w.setSteps(0);
		}
		if(!et2.getText().toString().trim().equals("")) {
			weight = Integer.parseInt(et2.getText().toString());
			w.setWeight(weight);

		}
		else {
			w.setWeight(0);
		}
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, RatingActivity.class).putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
}
}
