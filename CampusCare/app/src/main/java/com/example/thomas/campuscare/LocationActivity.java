package com.example.thomas.campuscare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LocationActivity extends AppCompatActivity {
    private String univ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Intent i = getIntent();
        univ = i.getStringExtra("univName");
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        Button enableLoc = (Button) findViewById(R.id.enableLocBut);
        enableLoc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //move on to the next activity
                //actionActivity is the next activity that will be made
                Intent i = new Intent(LocationActivity.this, actionActivity.class);
                i.putExtra("univName", univ);
                startActivity(i);
            }
        });
    }
}
