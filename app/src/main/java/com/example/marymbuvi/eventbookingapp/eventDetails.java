package com.example.marymbuvi.eventbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class eventDetails extends AppCompatActivity{

    ImageView imgview;
    TextView txtTitle, txtVenue, txtDate, txtDescription;
    Button btnBook;

    int images[] = {
            R.mipmap.event1,
            R.mipmap.event2,
            R.mipmap.event3,
            R.mipmap.event5
    };
    String[] Title = {
        "Churchill Show","Untamed","Gospel hour","RickRoss in Kenya"
    };
    String[] Venue = {
            "Cannivore","Kasarani stadium","KICC","Kempiski Malindi"
    };
    String[] Date = {
            "2018-05-26","2018-06-06","2018-05-12","2018-08-25"
    };
    String[] Description = {
            "The event will begin at 2:00pm to 10:00pm. Come and witness your favourite comedians on stage.",
            "The event will be from 6:00pm-7:00am. You cannot be left out on this!!",
            "Come all for a worship and praise kesha as from 5:00pm-12:00am.",
            "Your all time hip-hop artist is in kenya. Do not miss out on his hits!!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imgview = (ImageView) findViewById(R.id.imageView3);
        txtTitle = (TextView) findViewById(R.id.title);
        txtDate = (TextView) findViewById(R.id.date);
        txtVenue = (TextView) findViewById(R.id.venue);
        txtDescription = (TextView) findViewById(R.id.description);

        int position = getIntent().getIntExtra("data",0);
        imgview.setImageResource(images[position]);
        txtTitle.setText(Title[position]);
        txtDescription.setText(Description[position]);
        txtVenue.setText(Venue[position]);
        txtDate.setText(Date[position]);

        btnBook = (Button) findViewById(R.id.book);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent event = new Intent(eventDetails.this,BookHere.class);
                startActivity(event);

            }
        });
    }


}
