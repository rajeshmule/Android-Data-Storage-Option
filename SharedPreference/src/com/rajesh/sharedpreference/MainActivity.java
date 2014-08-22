package com.rajesh.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
   
	EditText name, no;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText1);
        no = (EditText) findViewById(R.id.editText2);
        
        
        
        
        
    }

    public void save(View view) {
    	
    	//Save the data in database using shared preferences  
    	
    	SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sharedPreferences.edit();
    	editor.putString("na", name.getText().toString());
    	editor.putString("no", no.getText().toString());
    	
    	editor.commit(); 
    	
		Toast.makeText(this, "Save successfully.", Toast.LENGTH_SHORT).show();
	}
    public void show(View view) {
		Toast.makeText(this, "show", Toast.LENGTH_SHORT).show();
		Intent intent= new Intent(this, Main2Activity.class);
		startActivity(intent);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
