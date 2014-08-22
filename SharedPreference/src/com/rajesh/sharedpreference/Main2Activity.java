package com.rajesh.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends ActionBarActivity {

	public static final String DEFAULT="N/A";
	TextView nametextview, notextview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		
		
		nametextview = (TextView) findViewById(R.id.tvname);
		notextview = (TextView) findViewById(R.id.tvno);
		
	}

	public void show (View view)
	{
		//How to data load from the database
		
		SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
		String name = sharedPreferences.getString("na", DEFAULT);
		String no = sharedPreferences.getString("no", DEFAULT);
		
		if(name.equals(DEFAULT) || no.equals(DEFAULT)){
			Toast.makeText(this, "No Data was found.", Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(this, "Data load successfully.", Toast.LENGTH_SHORT).show();
			nametextview.setText(name);
			notextview.setText(no);
		}
	}
	public void back (View view) {
	Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
	Intent intent=new Intent(this,MainActivity.class);
	startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
