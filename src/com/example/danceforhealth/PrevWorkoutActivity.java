package com.example.danceforhealth;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class PrevWorkoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prev_workout);
		//view = (PrevWorkoutView) findViewById(R.id.prevWorkoutView);
		//view.act = this;
		
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

	
    protected void createButtons(){
    // dynamically created buttons work just need to
    LinearLayout scrViewButLay = (LinearLayout) findViewById(R.id.scrollView1);
    scrViewButLay.removeAllViews();
    
    PrevWorkout pw = PrevWorkout.getInstance();
	List<Workout> all = pw.getPrevious();
    
    Button[] allButtons = new Button[all.size()];
    Log.i("Showing workout", "num buttons = " + all.size());
    for(int i = 0; i < all.size(); i++){
        Log.i("DB_NAME_TAG", all.get(i).toString());
    }
    for (int index = 0; index < all.size(); index++) {
        allButtons[index] = new Button(this); 
        allButtons[index].setText(all.get(index).toString());
        scrViewButLay.addView(allButtons[index]);
        allButtons[index].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Each buttons specific event
                /*
                 * Left off here
                 */
                Intent intent = new Intent();
                startActivity(intent);
                
            }
        });
    }

    // end of dynamically allocated buttons
}
	
	
}
