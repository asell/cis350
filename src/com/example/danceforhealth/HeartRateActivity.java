package com.example.danceforhealth;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HeartRateActivity extends Activity {
	
	TextView tv;
	CountDownTimer timer;
	private Workout w;
	private int heartrate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heart_rate);
		tv = (TextView)findViewById(R.id.timerText);
        timer = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv.setText("Time left: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tv.setText("done!");
            }
         };
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    w = (Workout) extras.get("workout");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heart_rate, menu);
		return true;
	}
	
	public void startTimer(View view) {
		timer.start();
	}
	
	public void onNextButtonClick(View view) {
		
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, WorkoutSummary.class);
		//.putExtra("workout", w);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
