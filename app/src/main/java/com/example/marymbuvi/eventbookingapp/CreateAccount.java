package com.example.marymbuvi.eventbookingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText first_name, sur_name, email, password, phone;
    Button btnCreate;
    RadioGroup gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        myDb = new DatabaseHelper(this);

        first_name = (EditText) findViewById(R.id.editFname);
        sur_name = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        gender = (RadioGroup) findViewById(R.id.radioGroup);
        password = (EditText) findViewById(R.id.editText7);
        phone = (EditText) findViewById(R.id.editText4);
        btnCreate = (Button) findViewById(R.id.button);
        CreateAcc();
    }

    public void CreateAcc(){
        btnCreate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(first_name.getText().toString(),sur_name.getText().toString(),
                                email.getText().toString(),phone.getText().toString(),gender.getCheckedRadioButtonId(),password.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(CreateAccount.this, "You have successfully created an account!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CreateAccount.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }

                }
        );
    }
}
