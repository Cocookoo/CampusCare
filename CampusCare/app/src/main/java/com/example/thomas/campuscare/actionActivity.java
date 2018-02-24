package com.example.thomas.campuscare;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actionActivity extends AppCompatActivity {
    private String univ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        Intent i = getIntent();
        univ = i.getStringExtra("univName");
        addListenerOnButton();

    }

    public void addListenerOnButton(){
        Button holdBut = (Button) findViewById(R.id.holdBut);
        final Handler handle = new Handler();
        final Runnable run = new Runnable(){
            @Override
            public void run(){
                //call the cops
                //add code that makes the app find the phone number to call the university and then call them if the button is not held down
                //for more than 20 seconds
                TextView tView = new TextView(actionActivity.this);
            }
        };

        holdBut.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //do nothing
                        handle.removeCallbacks(run);
                        break;
                    case MotionEvent.ACTION_UP:
                        handle.postDelayed(run,10000);
                        break;
                }
                return false;
            }
        });
    }
}
