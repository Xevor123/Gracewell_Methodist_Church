package com.example.gracewellchurchbotnav.ui.Volunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gracewellchurchbotnav.R;
import com.google.firebase.database.DatabaseReference;

public class AdminAddVolunteerActivity extends AppCompatActivity {

    DatabaseReference GracewellVolunteerEventDB;

    EditText volEventTitle;

    EditText volMax;

    EditText volOrgName;

    EditText volAddNote;

    EditText volAddress;

    EditText volDate;

    EditText volStart;

    EditText volEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_volunteer);

        volEventTitle = findViewById(R.id.txtVolunteerEvent);

        volMax = findViewById(R.id.txtMaxVolunteer);

        volOrgName = findViewById(R.id.txtOrgName);

        volAddNote = findViewById(R.id.txtAddInf);

        volAddress = findViewById(R.id.txtEventLocation);

        volDate = findViewById(R.id.txtDateOfEvent);

        volStart = findViewById(R.id.txtStartTime);

        volEnd = findViewById(R.id.txtEndTime);

        Button createVolEvent = (Button) findViewById(R.id.btnVolunteerSubmit);

        createVolEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (volEventTitle != null||volMax != null||volOrgName != null||volAddNote != null||volAddress != null||volDate != null||volStart != null||volEnd != null){
                    volEventTitle.getText();
                    volMax.getText();
                    volOrgName.getText();
                    volAddress.getText();
                    volAddNote.getText();
                    volDate.getText();
                    volStart.getText();
                    volEnd.getText();

                    
                }
            }
        });

    }
}