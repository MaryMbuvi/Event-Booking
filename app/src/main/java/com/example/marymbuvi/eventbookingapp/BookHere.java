package com.example.marymbuvi.eventbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookHere extends AppCompatActivity {


    EditText phone, name;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_here);


        phone = (EditText) findViewById(R.id.phoneNo);
        name = (EditText) findViewById(R.id.names);
        next = (Button) findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextPg = new Intent(getApplicationContext(),Payment.class);
                startActivity(nextPg);
            }
        });

    }


}
