package com.example.marymbuvi.eventbookingapp;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

public class makeBooking extends AppCompatActivity {

    GridView mygridview;
    SearchView searchView;



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchView = (SearchView) findViewById(R.id.searchView);
        mygridview = (GridView) findViewById(R.id.gridview);


        ImageAdapter adapter = new ImageAdapter(this);
        mygridview.setAdapter(adapter);
        mygridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long l) {
                Intent details = new Intent(makeBooking.this,eventDetails.class);
                details.putExtra("data",positon);
                startActivity(details);
            }
        });


    }
}
