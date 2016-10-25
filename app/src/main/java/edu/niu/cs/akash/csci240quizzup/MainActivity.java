/********************************************************************
 * Project Name: CSCI 240 Quizzup! GRADUATE STUDENT PROJECT
 * Author : Akash Rangojoo
 * Z ID : Z1717009
 * Description: This is the main activity, with the drop down to select week. when a week is selected
 *              process is moved to next activity where questions are displayed.
 *********************************************************************/



package edu.niu.cs.akash.csci240quizzup;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner mySpinner;
    public String selection;
    Button goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner = (Spinner) findViewById(R.id.spinner1);
        String [] items = new String[2];
        items[0]="Week 1";
        items[1]="Week 2";
        goBtn = (Button) findViewById(R.id.goButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.my_spinner_style, items) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                Typeface externalFont=Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
                ((TextView) v).setTypeface(externalFont);
                return v;
            }

            public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View v =super.getDropDownView(position, convertView, parent);
                Typeface externalFont=Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
                ((TextView) v).setTypeface(externalFont);
                ((TextView) v).setHeight(50);
                return v;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = parent.getItemAtPosition(position).toString();
                if(selection.equals("Week 1")) selection="1";
                else if(selection.equals("Week 2")) selection="2";
                goBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
                        intent.putExtra("weekID", selection);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
