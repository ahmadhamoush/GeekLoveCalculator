package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int  MAX = 100;
    TextView percentage;
    TextView scores;
    EditText name;
    String random_number;
    Spinner spinner;
    TableLayout table;
    private ArrayList<List<String>> array;
    ImageView logo;
    ArrayList<String> temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        array= new ArrayList<List<String>>();
        percentage = (TextView) findViewById(R.id.percentage);
        name = (EditText) findViewById(R.id.name);
        scores = (TextView) findViewById(R.id.scores);
        logo = (ImageView) findViewById(R.id.logo);
        logo.setImageDrawable(null);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }
    public void reset(View v){
        logo.setImageDrawable(null);
        name.setText("");
        scores.setText("");
        scores.setHint("Scores");
        percentage.setText("");
        temp.clear();
        array.clear();
    }
    public void generate(View v){
        String text = spinner.getSelectedItem().toString();
       if(name.getText().toString().isEmpty()){
           percentage.setText("Please enter a name");
       }
       else{
           logo.setTranslationX(-2500);
           temp = new ArrayList<String>();
           Random random = new Random();
           random_number = String.valueOf(random.nextInt(MAX));
           temp.add("Language: " + spinner.getSelectedItem().toString());
           temp.add("Percentage: " + random_number + "%");
           array.add(temp);
           percentage.setText(name.getText() + " + " + text +" = " + random_number +"%");
           scores.setText(array.toString());

           if(text.equalsIgnoreCase("Java")){
               logo.setImageResource(R.drawable.java);
           }
           if(text.equalsIgnoreCase("JavaScript")){
               logo.setImageResource(R.drawable.js);
           }
           if(text.equalsIgnoreCase("PHP")){
               logo.setImageResource(R.drawable.php);
           }
           if(text.equalsIgnoreCase("swift")){
               logo.setImageResource(R.drawable.swift);
           }
           if(text.equalsIgnoreCase("python")){
               logo.setImageResource(R.drawable.python);
           }
           if(text.equalsIgnoreCase("c++")){
               logo.setImageResource(R.drawable.c);
           }
           logo.animate().translationXBy(2500).rotation(3600).setDuration(500);
       }
        }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}