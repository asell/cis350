package com.example.danceforhealth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RatingActivity extends Activity{
	private Workout w;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    w = (Workout) extras.get("workout");
		}
		
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		TextView tv3 = (TextView) findViewById(R.id.textView3);
		TextView tv4 = (TextView) findViewById(R.id.textView6);
		Button b = (Button) findViewById(R.id.button1);
		Typeface font = Typeface.createFromAsset(getAssets(), "Komika_display.ttf");
		tv1.setTypeface(font);
		tv2.setTypeface(font);
		tv3.setTypeface(font);
		tv4.setTypeface(font);
		b.setTypeface(font);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rating, menu);
		return true;
	}
	
	public void onNextButtonClick(View view) {
		RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
		int id1 = rg1.getCheckedRadioButtonId();
		RadioButton b1 = (RadioButton) findViewById(id1);
		int index1 = rg1.indexOfChild(b1);
		
		RadioGroup rg2 = (RadioGroup) findViewById(R.id.RadioGroup01);
		int id2 = rg2.getCheckedRadioButtonId();
		RadioButton b2 = (RadioButton) findViewById(id2);
		int index2 = rg2.indexOfChild(b2);
		
		RadioGroup rg3 = (RadioGroup) findViewById(R.id.RadioGroup04);
		int id3 = rg3.getCheckedRadioButtonId();
		RadioButton b3 = (RadioButton) findViewById(id3);
		int index3 = rg3.indexOfChild(b3);
		
		int liked = 7 - index1 + 1;
		int fun = 7 - index2 + 1;
		int tired = index3 + 1;
		// strain is average of survey
		int strain = (liked + fun + tired)/3;
		
			// create an Intent using the current Activity 
			// and the Class to be created
			w.setStrain(strain);
			
			Log.v("duration", "= " + w.getTime());
			
			Intent i = new Intent(this, WeightAndStepsActivity.class).putExtra("workout", w);
	
			// pass the Intent to the Activity, 
			// using the specified request code
			startActivity(i);
		
	}
//	public void onBackButtonClick(View view) {
//		
//		// create an Intent using the current Activity 
//		// and the Class to be created
//		Intent i = new Intent(this, NewWorkoutActivity.class).putExtra("workout", w);
//
//		// pass the Intent to the Activity, 
//		// using the specified request code
//		startActivity(i);
//}
}
