package com.example.danceforhealth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class StepOneView extends View {

	private Canvas canvas;					// the current canvas
	private Bitmap image;					// the heart rate image
	
	public StepOneView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init() {
		/* one-time initialization stuff */
		//setBackgroundColor(0xFF00FF00);
		
		// create the image of the unicorn
		//image = BitmapFactory.decodeResource(getResources(), R.drawable.hr);
		//image = Bitmap.createScaledBitmap(image, 150, 150, false);
	}
	
	@Override
	public void onDraw(Canvas c) {
		/* called each time this View is drawn */
		//canvas = c;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		return false;
	}
	
}
