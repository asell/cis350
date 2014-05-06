package com.example.danceforhealth;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class WeekProgressActivity extends Activity {

	private XYPlot plot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_week_progress);
		
		// initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
 
        // Get previous workouts
    	PrevWorkout pw = PrevWorkout.getInstance();
    	List<Workout> workouts = pw.getPrevious();
    	
    	// get current date and week
		Date current = new Date();
		String[] temp = current.toString().split(" ");
		Integer currentDay = Integer.parseInt(temp[2]);
		String currentDOW = temp[0];
		int min = sortDay(currentDOW);
		
    	// turn workouts into an array of values
    	Number[] values = new Number[8];
    	int count = 0;
    	
    	// sort workouts by date
    	for (Workout w : workouts) {
    		String[] date = w.getDate().split(" ");
    		Integer day = Integer.parseInt(date[2]);
    		Integer month = Integer.parseInt(date[1]);
    		Integer year = Integer.parseInt(date[3]);
    		String dow = date[0];
    		
    		// check if day is in this week
    		Calendar c = Calendar.getInstance();
    		c.set(year, month-1, day);
    		long time = c.getTimeInMillis();
    		long now = current.getTime();
    		long millsInDay = 86400000;
    		
    		if ((now-time)/millsInDay <= min && (now-time)/millsInDay >= 0) {
    			count++;
    			values[sortDay(dow)] = w.getWeight();
    		}
    	}
    	
    	if ((count < min + 1) && (workouts.size() > count)) {
    		int base = workouts.get(workouts.size() - count - 1).getWeight();
    		boolean toggle = true;
    		for (int i = 1; i < min; i++) {
    			if ((Integer)values[i] == null) {
    				if (toggle) values[i] = base;
    				else values[i] = values[i-1];
    			}
    			else toggle = false;
    		}
    	}
 
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(values),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "This Week");                           // Set the display title of the series
 
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.RED, null, null);

 
        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
 
        // reduce the number of range labels
        plot.getGraphWidget().setDomainLabelOrientation(-45);
        plot.setDomainBoundaries(1, 7, BoundaryMode.FIXED);
        plot.setRangeBoundaries(50, 200, BoundaryMode.FIXED);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1.0);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 10.0);

		Typeface font_two = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		Button pr = (Button) findViewById(R.id.back);
		pr.setTypeface(font_two);
		
	}
	
	private int sortDay(String day) {
		if (day.equals("Mon")) {
			return 1;
		} else if (day.equals("Tue")) {
			return 2;
		} else if (day.equals("Wed")) {
			return 3;
		} else if (day.equals("Thu")) {
			return 4;
		} else if (day.equals("Fri")) {
			return 5;
		} else if (day.equals("Sat")) {
			return 6;
		} else {
			return 7;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.week_progress, menu);
		return true;
	}
	
	public void onBackButtonClick(View view) {
		//end activity and go back to the home page
		finish();
	}

}
