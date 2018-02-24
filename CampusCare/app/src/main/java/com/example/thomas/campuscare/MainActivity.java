package com.example.thomas.campuscare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //addItemsOnSpinner1();
        addListenerOnButton();
        addListenerOnSpinnerItemSelect();
    }

    //adds items onto spinner dynamically
    /**
    public void addItemsOnSpinner1(){
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<>();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }
     */

    public void addListenerOnSpinnerItemSelect(){
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
                selectedItem = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0){

            }
        });
        //spinner1.setOnItemSelectedListener();
        //add an item listener onto the items
    }

    public void addListenerOnButton(){
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        Button b = (Button) findViewById(R.id.SubmitBut);
        b.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(selectedItem.equals("Choose One")){
                    //error message
                    AlertDialog.Builder dia = new AlertDialog.Builder(MainActivity.this);
                    dia.setMessage("Choose a university");
                    dia.setTitle("Error");
                    dia.setPositiveButton("OK", null);
                    dia.setCancelable(true);
                    dia.create().show();
                    dia.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int which){
                                }
                            });
                }
                else{

                    //Move to the next activity(depends on whether the location is on or off)
                    Intent i;
                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) && !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                        //All location services are disabled
                        i = new Intent(MainActivity.this, LocationActivity.class);
                    }//otherwise they are on
                    else {
                        i = new Intent(MainActivity.this, actionActivity.class);
                    }
                    i.putExtra("univName", selectedItem);
                    startActivity(i);
                }
            }
        });
    }
}