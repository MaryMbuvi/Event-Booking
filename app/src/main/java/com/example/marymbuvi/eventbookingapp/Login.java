package com.example.marymbuvi.eventbookingapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements OnClickListener{
    EditText phoneNo, pword;
    Button signIn, mReg;
    TextView resetPword, CreateAcc;
    ImageView image;
    SQLiteDatabase db;
    Cursor myCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNo = (EditText) findViewById(R.id.phone);
        pword = (EditText) findViewById(R.id.pword);
        signIn = (Button) findViewById(R.id.login);
        resetPword = (TextView) findViewById(R.id.reset);
        CreateAcc = (TextView) findViewById(R.id.create);
        image = (ImageView) findViewById(R.id.imageView4);
        mReg = findViewById(R.id.btnCreate);

        mReg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CreateAccount.class));
            }
        });

        signIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openOrCreateDatabase("Clients", Context.MODE_PRIVATE, null);
                db.setVersion(1);
                db.execSQL("CREATE TABLE IF NOT EXISTS clients_table(fname VARCHAR NOT NULL, sur_name VARCHAR NOT NULL, email VARCHAR NOT NULL, phone INT NOT NULL,  gender VARCHAR NOT NULL, password VARCHAR NOT NULL);");

                myCursor = db.rawQuery("SELECT * FROM clients_table", null);
                int count = myCursor.getCount();
                if (count == 0) {
                    Intent x = new Intent(Login.this, makeBooking.class);
                    startActivity(x);
                }

            }
        });

    }

    public void checkLogin(View v)
    {
        String phone = phoneNo.getText().toString();
        if(phoneExists(phone))
        {
            login(null);
        }
        else
        {
            Toast.makeText(this, "user does not exist", Toast.LENGTH_SHORT).show();
        }
    }
    public void login(View view)
    {
        Cursor myCursor2 = null;
        String phone = phoneNo.getText().toString();
        String password = pword.getText().toString();
        try
        {
            myCursor2 = db.rawQuery("SELECT * FROM clients_table WHERE phone='"+phoneNo+"' AND password='"+pword+"'", null);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "user does not exist", Toast.LENGTH_LONG).show();
        }
        if(myCursor2.getCount() == 1)
        {
            startActivity(new Intent(Login.this,makeBooking.class));
            finish();
        }
        else
        {
            Toast.makeText(this, "password is wrong", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean phoneExists(String user)
    {
        try
        {
            Cursor myCursor = db.rawQuery("SELECT * FROM clients_table WHERE phone='"+phoneNo+"'",null);
            int count = myCursor.getCount();
            if(count > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
        return false;
    }
    @Override
    public void onBackPressed()
    {
//		 super.onBackPressed();
    }


    @Override
    public void onClick(View view) {

    }
}
