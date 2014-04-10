package com.example.danceforhealth;
import java.util.List;

import com.example.danceforhealth.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class DummyActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dummy);
		
		
		createWorkout();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dummy, menu);
		return true;
	}

	public void createWorkout() {
		
		Workout wo = new Workout("Dance", 10, 180, 500, 140);

		PrevWorkout pw = PrevWorkout.getInstance();
		List<Workout> all = pw.getPrevious();
		
		all.add(wo);
		
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
