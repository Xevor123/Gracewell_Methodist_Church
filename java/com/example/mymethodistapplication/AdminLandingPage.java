package com.example.mymethodistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminLandingPage extends AppCompatActivity {

    Button NavToAddEvents;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_landing_page);

        NavToAddEvents = (Button) findViewById(R.id.NavToAddEvents);
        NavToAddEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddEventsActivity();
            }


        });
    }

    private void openAddEventsActivity() {
        Intent intent = new Intent(this, AdminAddEventsActivity.class);
        startActivity(intent);
    }
}