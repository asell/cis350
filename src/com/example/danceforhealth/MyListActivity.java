package com.example.danceforhealth;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListActivity extends ListActivity {
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    
    Workout[] values = new Workout[] { new Workout("Dance", 0, 87, 346, 179) , 
    		new Workout("Swim", 15, 180, 45, 120), new Workout("Run", 0, 180, 899, 150)};

    
    View header = getLayoutInflater().inflate(R.layout.header, null);
    View footer = getLayoutInflater().inflate(R.layout.footer, null);
    ListView listView = getListView();
    listView.addHeaderView(header);
    listView.addFooterView(footer);
    
    // use your custom layout
    ArrayAdapter<Workout> adapter = new MySimpleArrayAdapter(this, values);
    setListAdapter(adapter);
  }
  
	public void onBackButtonClick(View view) {
		// create an Intent using the current Activity 
		// and the Class to be created
		Intent i = new Intent(this, HomeActivity.class);

		// pass the Intent to the Activity, 
		// using the specified request code
		startActivity(i);
	}
  
  
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    Workout item = (Workout) getListAdapter().getItem(position - 1);
    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    
    
	  
	Intent i = new Intent();
	Bundle b = new Bundle();
	b.putParcelable("workout", item);
	i.putExtras(b);

	i.setClass(v.getContext(), WorkoutSummary.class);

	// pass the Intent to the Activity, 
	// using the specified request code
	startActivity(i);
  
    
    
  }
} 