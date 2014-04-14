package com.example.danceforhealth;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HeartRateActivity extends Activity {
	
	TextView tv;
	CountDownTimer timer;

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
//	public class MyTimer extends CountDownTimer {
//        public MyTimer(long millisInFuture, long countDownInterval) {
//            super(millisInFuture, countDownInterval);
//            // TODO Auto-generated constructor stub
//            //tv.setText("changed by the constructor");
//        }
//
//        @Override
//        public void onFinish() {
//            // TODO Auto-generated method stub
//            tv.setText("done!");
//        }
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//            // TODO Auto-generated method stub
//            tv.setText("Time: " + millisUntilFinished);
//        }

    //}

}
