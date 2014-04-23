package com.example.danceforhealth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<Workout> {
	private final Context context;
	private final Workout[] values;

	public MySimpleArrayAdapter(Context context, Workout[] values) {
		super(context, R.layout.row_data, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_data, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.secondLine);
		TextView type = (TextView) rowView.findViewById(R.id.firstLine);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		//imageView.setImageResource(R.drawable.heart); // this should be changed!!
		textView.setText(values[position].getDate());
		type.setText(values[position].getType());
		// Change the icon for Windows and iPhone
		int feeling = values[position].getStrain();

		return rowView;
	}
} 