package com.example.mymethodistapplication;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mymethodistapplication.databinding.ActivityAdminAddEventsBinding;
import com.example.mymethodistapplication.databinding.ActivityRegisterPageBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminAddEventsActivity extends AppCompatActivity {
    DatabaseReference GracewellEventsDB;

    ListView eventsList;
    EditText eventName;
    EditText eventDate;
    EditText eventTime;
    EditText eventLocation;

    Button SaveEventButton;

    ProgressBar progressBar;

    ActivityAdminAddEventsBinding binding;


    public static final String TAG = "AdminActivity";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_events);
        binding = ActivityAdminAddEventsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding = ActivityAdminAddEventsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //eventsList = findViewById(R.id.eventsList);

        eventName = findViewById(R.id.eventName);
        eventDate = findViewById(R.id.eventDate);
        eventTime = findViewById(R.id.eventTime);
        eventLocation = findViewById(R.id.eventLocation);
        SaveEventButton = findViewById(R.id.SaveEventButton);
        progressBar = findViewById(R.id.ProgressBar);

        GracewellEventsDB = FirebaseDatabase.getInstance().getReference().child("GracewellEventsDB");
        SaveEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertEventsData();
            }

        });

    }


    private void insertEventsData() {

        String EName = eventName.getText().toString();
        String EDate = eventDate.getText().toString();
        String ETime = eventTime.getText().toString();
        String ELocation = eventLocation.getText().toString();

        GracewellEventsDB GracewellEventDB = new GracewellEventsDB(EName, EDate, ETime, ELocation);

        GracewellEventsDB.push().setValue(GracewellEventDB);

        Toast.makeText(AdminAddEventsActivity.this,"Event Has Been Created!",Toast.LENGTH_SHORT).show();
        saveEvent(EName, EDate, ETime, ELocation);


    }

    private void saveEvent(String eName, String eDate, String eTime, String eLocation) {

        }


    }
