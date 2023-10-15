package com.example.mymethodistapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class JoinMinFormActivity extends AppCompatActivity {

    EditText txtFullName;
    EditText txtEmail;
    EditText txtCellphone;
    EditText txtDoB;
    EditText txtAddress;
    EditText txtAddNotes;
    RadioGroup btnJobs;
    RadioButton btnSelectedJob;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_min_form);

        if (findViewById(R.id.main_activity) != null) {
            if (savedInstanceState != null) {
                return;
            }
        }
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.sermons_nav) {
                startActivity(new Intent(getApplicationContext(), SermonsPage.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.events_nav) {
                startActivity(new Intent(getApplicationContext(), EventsActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.contactus_nav) {
                startActivity(new Intent(getApplicationContext(), ContactUs.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.menu_nav) {

                showPopupMenu(bottomNavigationView);

                return true;
            }
            else if (item.getItemId() == R.id.home_nav) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(0, 0);
                return true;

            }


            return false;
        });

    }

    private void showPopupMenu(BottomNavigationView bottomNavView) {
        PopupMenu popupMenu = new PopupMenu(this, bottomNavView, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Set up a listener for the items in the popup menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();


                if (itemId == R.id.nav_Donations)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Appointments)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this, AppointmentsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Log_Out)
                {
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    mAuth.signOut();
                    Intent intent = new Intent(JoinMinFormActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (itemId == R.id.nav_Comm_Chat)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this,CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Photos)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this,Photos1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_About)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this, About1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Account)
                {
                    Intent intent = new Intent(JoinMinFormActivity.this, Account.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
        popupMenu.show();


        txtFullName = findViewById(R.id.txtJoinMinFormFullName);
        txtEmail = findViewById(R.id.txtJoinMinFormEmail);
        txtCellphone = findViewById(R.id.txtJoinMinFormPhoneNum);
        txtDoB = findViewById(R.id.txtJoinMinDOB);
        txtAddress = findViewById(R.id.txtJoinMinFormAddress);
        txtAddNotes = findViewById(R.id.txtJoinMinFormAddNotes);
        btnJobs = findViewById(R.id.btnGrpJoinMinChoices);
        btnSubmit = findViewById(R.id.btnJoinMinFormSubmit);
        //GracewellJoinMinistryDB = FirebaseDatabase.getInstance().getReference().child("GracewellJoinMinistryDB");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectID = btnJobs.getCheckedRadioButtonId();
                btnSelectedJob = (RadioButton) findViewById(selectID);
                insertEventsData();
                //open home activity on successful submission
            }
        });

    }

    private void insertEventsData(){
        String FullName = txtFullName.getText().toString();
        String Email = txtEmail.getText().toString();
        String Cellphone = txtCellphone.getText().toString();
        String DateOfBirth = txtDoB.getText().toString();
        String Address = txtAddress.getText().toString();
        String AdditionalNotes = txtAddNotes.getText().toString();
        String JobChoice = btnSelectedJob.getText().toString();

       // GracewellJoinMinistryDB GracewellJoinMinistryDB = new GracewellJoinMinistryDB(FullName, Email, Cellphone, DateOfBirth, Address, AdditionalNotes, JobChoice);

        //GracewellJoinMinistryDB.push().setValue(GracewellJoinMinistryDB);

        Toast.makeText(this, "Form has been Submitted", Toast.LENGTH_SHORT).show();
        saveJoinMinForm(FullName, Email, Cellphone, DateOfBirth, Address, AdditionalNotes, JobChoice);
    }

    private void saveJoinMinForm (String fName, String email, String cellPhone, String dateOfBirth, String address, String addNotes, String jobChoice){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a new document with a generated ID
        Map<String, Object> data = new HashMap<>();
        data.put("FullName", fName);
        data.put("Email", email);
        data.put("Cellphone", cellPhone);
        data.put("DateOfBirth", dateOfBirth);
        data.put("Address", address);
        data.put("AdditionalNotes", addNotes);
        data.put("JobChoice", jobChoice);

        // Add the data to the "JoinMinistry" collection
        db.collection("JoinMinistry")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    // Data added successfully
                    Toast.makeText(JoinMinFormActivity.this, "Form has been submitted", Toast.LENGTH_SHORT).show();

                    // Optionally, you can open a new activity or perform another action here.
                })
                .addOnFailureListener(e -> {
                    // Handle any errors that occurred during the data insertion
                    Toast.makeText(JoinMinFormActivity.this, "Error submitting form: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}