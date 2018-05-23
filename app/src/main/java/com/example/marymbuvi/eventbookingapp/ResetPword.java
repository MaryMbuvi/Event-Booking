package com.example.marymbuvi.eventbookingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ResetPword extends AppCompatActivity {
    EditText mail;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pword);

        mail = (EditText) findViewById(R.id.email);
        submit = (Button) findViewById(R.id.btnSubmit);

    }
}
