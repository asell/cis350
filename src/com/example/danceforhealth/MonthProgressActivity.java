package com.example.danceforhealth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

public class MonthProgressActivity extends Activity {

	private XYPlot plot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_month_progress);

		// initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);

        // Get previous workouts
    	PrevWorkout pw = PrevWorkout.getInstance();
    	List<Workout> workouts = (ArrayList<Workout>) pw.getPrevious();
 
        // get current date and month
        Date d = new Date();
        SimpleDateFormat ft = 
				new SimpleDateFormat ("E M dd yyyy");
		String current = ft.format(d);
		String[] temp = current.toString().split(" ");
		int currentDay = Integer.parseInt(temp[2]);
		String currentMonth = temp[1];
        
		int count = 0;
		Number[] values = new Number[32];
		for (Workout w : workouts) {
			String[] date = w.getDate().split(" ");
    		int day = Integer.parseInt(date[2]);
    		String month = date[1];
    		if (month.equals(currentMonth)) {
    			values[day] = w.getWeight();
    			count++;
    		}
		}
		
		if ((count < currentDay) && (workouts.size() > count)) {
    		int base = workouts.get(count-1).getWeight();
    		boolean toggle = true;
    		for (int i = 1; i < values.length; i++) {
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
                "This Month");                           // Set the display title of the series
 
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.RED, Color.RED, null);

 
        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
 
        // reduce the number of range labels
        plot.getGraphWidget().setDomainLabelOrientation(-45);
        plot.setDomainBoundaries(1, 31, BoundaryMode.FIXED);
        plot.setRangeBoundaries(50, 200, BoundaryMode.FIXED);
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 5.0);
        plot.setRangeStep(XYStepMode.INCREMENT_BY_VAL, 10.0);

		Typeface font_two = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		Button pr = (Button) findViewById(R.id.back);
		pr.setTypeface(font_two);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.month_progress, menu);
		return true;
	}

	public void onBackButtonClick(View view) {
		//end activity and go back to the home page
		finish();
	}
	
}
