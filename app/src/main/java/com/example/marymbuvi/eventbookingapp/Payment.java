package com.example.marymbuvi.eventbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    Button jamboPay, mPesa;
    DatabaseHelper eventDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        eventDb = new DatabaseHelper(this);
        jamboPay = (Button) findViewById(R.id.jp);
        mPesa = (Button) findViewById(R.id.mpesa);
//        AddData();

        mPesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchsimtoolkit = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if (launchsimtoolkit != null){
                    startActivity(launchsimtoolkit);
                }
            }
        });
    }
//    public void AddData(){
//        mPesa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                boolean isInserted = eventDb.insertEventData(name.getText().toString(),phone.getText().toString());
//                if (isInserted = true)
//                    startActivity(new Intent(Payment.this,Payment.class));
//                else
//                    Toast.makeText(Payment.this, "invlid data", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
