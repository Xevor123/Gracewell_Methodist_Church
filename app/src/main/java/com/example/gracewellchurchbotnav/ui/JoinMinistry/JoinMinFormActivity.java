package com.example.gracewellchurchbotnav.ui.JoinMinistry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.example.gracewellchurchbotnav.R;
import com.example.gracewellchurchbotnav.ui.CommunityChat.CommunityChatActivity;
import com.example.gracewellchurchbotnav.ui.Volunteer.VolunteerActivity;
import com.example.gracewellchurchbotnav.ui.donations.DonationsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

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
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Call the onMenuItemSelected method from the outer class and pass the selected item
                int itemID = item.getItemId();

                if (itemID == R.id.navigation_menu)
                {
                    showPopupMenu(bottomNavigationView);
                    return true;
                }
                return false;
            }
        });

        txtFullName = findViewById(R.id.txtJoinMinFormFullName);
        txtEmail = findViewById(R.id.txtJoinMinFormEmail);
        txtCellphone = findViewById(R.id.txtJoinMinFormPhoneNum);
        txtDoB = findViewById(R.id.txtJoinMinDOB);
        txtAddress = findViewById(R.id.txtJoinMinFormAddress);
        txtAddNotes = findViewById(R.id.txtJoinMinFormAddNotes);
        btnJobs = findViewById(R.id.btnGrpJoinMinChoices);
        btnSubmit = findViewById(R.id.btnJoinMinFormSubmit);
        GracewellJoinMinistryDB = FirebaseDatabase.getInstance().getReference().child("GracewellJoinMinistryDB");

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

        GracewellJoinMinistryDB GracewellJoinMinistryDB = new GracewellJoinMinistryDB(FullName, Email, Cellphone, DateOfBirth, Address, AdditionalNotes, JobChoice);

        GracewellJoinMinistryDB.push().setValue(GracewellJoinMinistryDB);

        Toast.makeText(this, "Form has been Submitted", Toast.LENGTH_SHORT).show();
        saveJoinMinForm(FullName, Email, Cellphone, DateOfBirth, Address, AdditionalNotes, JobChoice);
    }

    private void saveJoinMinForm (String fName, String email, String cellPhone, String dateOfBirth, String address, String addNotes, String jobChoice){

    }

    private void showPopupMenu(BottomNavigationView bottomNavView) {
        PopupMenu popupMenu = new PopupMenu(this, bottomNavView, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

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
                if (itemId == R.id.nav_Comm_Chat){
                    Intent intent = new Intent(JoinMinFormActivity.this, CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer){
                    Intent intent = new Intent(JoinMinFormActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

}