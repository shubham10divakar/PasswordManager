package com.example.subhamdivakar.passwordmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

        // Set Duration of the Splash Screen
        long Delay = 5000;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Remove the Title Bar
            requestWindowFeature(Window.FEATURE_NO_TITLE);

            // Get the view from splash_activity.xml
            setContentView(R.layout.splash_activity);

            // Create a Timer
            Timer RunSplash = new Timer();

            // Task to do when the timer ends
            TimerTask ShowSplash = new TimerTask() {
                @Override
                public void run() {
                    // Close SplashScreenActivity.class
                    finish();

                    // Start MainActivity.class
                    Intent myIntent = new Intent(SplashActivity.this,NewUser.class);
                    startActivity(myIntent);
                }
            };

            // Start the timer
            RunSplash.schedule(ShowSplash, Delay);
        }
    }

