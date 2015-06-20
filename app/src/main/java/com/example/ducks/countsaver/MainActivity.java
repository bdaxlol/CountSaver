package com.example.ducks.countsaver;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
    public static final String PREFS_NAME = "CountFile";
    int theCount;
    EditText eText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        theCount = settings.getInt("count", 0);
        eText = (EditText) findViewById(R.id.editText);
        eText.setText(""+theCount);
    }

    public void advanceCount(View v) {
        //
        eText = (EditText) findViewById(R.id.editText);

        theCount++;
        eText.setText(""+theCount);
    }

    public void saveCount(View v) {
        //
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("count", theCount);
        editor.commit();
        eText = (EditText) findViewById(R.id.editText);
        eText.setText("Saved. "+theCount);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
