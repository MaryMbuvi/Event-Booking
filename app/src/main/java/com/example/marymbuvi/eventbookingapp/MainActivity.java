package com.example.marymbuvi.eventbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread splash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent menu = new Intent(MainActivity.this,Login.class);
                    startActivity(menu);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        splash.start();
    }
}
