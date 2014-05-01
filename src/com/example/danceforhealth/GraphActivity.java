package com.example.danceforhealth;

import java.util.Arrays;

import android.os.Bundle;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYSeries;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.xy.*;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GraphActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph);
		
		Typeface font_two = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		Button pr = (Button) findViewById(R.id.back);
		Button w = (Button) findViewById(R.id.week);
		Button m = (Button) findViewById(R.id.month);
		Button y = (Button) findViewById(R.id.year);
		pr.setTypeface(font_two);
		w.setTypeface(font_two);
		m.setTypeface(font_two);
		y.setTypeface(font_two);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.graph, menu);
		return true;
	}
	
	public void onBackButtonClick(View view) {
		//end activity and go back to the home page
		finish();
	}
	
	public void onWeekButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, WeekProgressActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	public void onMonthButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, MonthProgressActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	public void onYearButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, YearProgressActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}

}
