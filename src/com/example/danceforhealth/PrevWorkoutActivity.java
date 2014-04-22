package com.example.danceforhealth;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class PrevWorkoutActivity extends Activity {
	
	Button view;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prev_workout);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		TextView txt1 = (TextView) findViewById(R.id.textView1);
		Button b = (Button) findViewById(R.id.preWorkout);
		txt1.setTypeface(font);
		b.setTypeface(font);
		
		view = (Button) findViewById(R.id.button1); 
		view.setTypeface(font);
		
		PrevWorkout pw = PrevWorkout.getInstance();
		List<Workout> all = pw.getPrevious();

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		
		//Adapter adapter = new ArrayAdapter(all);
		
		ArrayAdapter<Workout> adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_spinner_item, all);
		spinner.setAdapter(adapter);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		final Workout selected = (Workout) spinner.getSelectedItem();
		
		view.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();
				Bundle b = new Bundle();
				b.putParcelable("this is the selected workout", selected);
				i.putExtras(b);
			
				i.setClass(v.getContext(), WorkoutSummary.class);
			
				// pass the Intent to the Activity, 
				// using the specified request code
				startActivity(i);
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prev_workout, menu);
		return true;
	}

	public void onBackButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HomeActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
	
	
	

	/**
    protected void createButtons(){
    // dynamically created buttons work just need to
    //LinearLayout scrViewButLay = (LinearLayout) findViewById(R.id.scrollView1);
   // scrViewButLay.removeAllViews();

    PrevWorkout pw = PrevWorkout.getInstance();
	List<Workout> all = pw.getPrevious();

    Button[] allButtons = new Button[all.size()];
    Log.i("Showing workout", "num buttons = " + all.size());

    for (int index = 0; index < all.size(); index++) {
        allButtons[index] = new Button(this); 
        allButtons[index].setText(all.get(index).toString());
      //  scrViewButLay.addView(allButtons[index]);
        allButtons[index].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Each buttons specific event
                /*
	 * Left off here
	 *
                Intent intent = new Intent();
                startActivity(intent);

            }
        });
    }

    // end of dynamically allocated buttons
}
	 */	
	


	
	

}
