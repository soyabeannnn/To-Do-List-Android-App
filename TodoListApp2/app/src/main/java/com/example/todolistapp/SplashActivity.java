package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // when the user launch the apps, display everything inside the activity xml file
        // create a scheduled task below, this task will close the current page
        // and open a new page, close splash activity and open main activity

        TimerTask task = new TimerTask(){
            public void run(){
                finish(); // close the current activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };
        Timer opening = new Timer(); //create timer object
        opening.schedule(task, 3000); //after 3 seconds run the scheduled process
    }
}