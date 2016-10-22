package com.example.truman.firstapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.InvalidParameterException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button diceRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        */

        //Defines TextViews and EditTexts
        final TextView diceOutput=(TextView) findViewById(R.id.diceOutputTextView);
        final TextView diceResult=(TextView) findViewById(R.id.diceResultTextView);
        final EditText diceInput=(EditText) findViewById(R.id.diceInputEditText);

        //Defines the ROLL button
        Button diceRoll=(Button) findViewById(R.id.diceRollButton);
        diceRoll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            try{

                DiceRollerResults results = DiceRoller.roll(diceInput.getText().toString());

                diceOutput.setText(String.valueOf(results.getTotal()));
                diceResult.setText(results.getRolls());

            }
            catch(InvalidParameterException ex){
                diceOutput.setText(ex.getMessage());
                diceResult.setText("");
            }
            }

        });

    }

    @Override
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
