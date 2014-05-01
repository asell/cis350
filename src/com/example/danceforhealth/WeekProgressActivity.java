package com.example.danceforhealth;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.ui.XLayoutStyle;
import com.androidplot.ui.YLayoutStyle;
import com.androidplot.ui.widget.Widget;
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
	private List<Workout> mon = new ArrayList<Workout>(), tue = new ArrayList<Workout>(), wed = new ArrayList<Workout>(), 
			thu = new ArrayList<Workout>(), fri = new ArrayList<Workout>(), sat = new ArrayList<Workout>(), 
			sun = new ArrayList<Workout>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_week_progress);
		
		// initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
 
        // Get previous workouts
    	PrevWorkout pw = PrevWorkout.getInstance();
    	List<Workout> workouts = (ArrayList<Workout>) pw.getPrevious();
    	
    	// get current date and week
		Date current = new Date();
		String[] temp = current.toString().split(" ");
		Integer currentDay = Integer.parseInt(temp[2]);
		String currentDOW = temp[0];
		int min = 0;
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		for (int i = 0; i < days.length; i++) {
			if (currentDOW.equals(days[i])) min = i;
		}
    	// sort workouts by date
    	for (Workout w : workouts) {
    		String[] date = w.getDate().split(" ");
    		Integer day = Integer.parseInt(date[2]);
    		String dow = date[0];
    		
    		if ((currentDay-day) <= min && (currentDay-day) >= 0) {
    			for (int i = 0; i < days.length; i++) 
    				if (dow.equals(days[i])) getDayWorkoutList(i).add(w);
    		}
    	}
    	// turn workouts into an array of values
    	Number[] values = {0, 0, 0, 0, 0, 0, 0, 0};
    	int count = 0;
    	for (int i = 0; i <= min; i++) {
    		if (getDayWorkoutList(i).size() != 0) { // if there is a workout that day
    			values[i+1] = getDayWorkoutList(i).get(0).getWeight();
    			count ++;
    		} else if (count > 0) { // if there is no workout, use the value from the day before
    			values[i+1] = values[i];
    			count ++;
    		} else {
    			values[i+1] = -1; // if there was no previous value, mark with -1
    		}
    	}
    	
    	if ((count < min + 1) && (workouts.size() > count)) {
    		int base = workouts.get(count-1).getWeight();
    		for (int i = 1; i < values.length; i++) {
    			if ((Integer)values[i] == -1) values[i] = base;
    		}
    	}
 
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(values),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "This Week");                           // Set the display title of the series
 
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.RED, Color.RED, null);

 
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
	
	private List<Workout> getDayWorkoutList(int num) {
		switch (num) {
		case 0: return mon;
		case 1: return tue;
		case 2: return wed;
		case 3: return thu;
		case 4: return fri;
		case 5: return sat;
		case 6: return sun;
		default: return null;
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
