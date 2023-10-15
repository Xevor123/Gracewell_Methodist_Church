package com.example.mymethodistapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class VolunteerActivity extends AppCompatActivity {

    CheckBox chkFoodBank, chkAnimalHandling, chkCleanUp, chkMonday, chkTuesday, chkWednesday, chkThursday, chkFriday, chkSaturday, chkSunday;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        if (findViewById(R.id.container) != null) {
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

        chkFoodBank = findViewById(R.id.chkFoodbank);
        chkAnimalHandling = findViewById(R.id.chkAnimalHandling);
        chkCleanUp = findViewById(R.id.chkCleanUp);
        chkMonday = findViewById(R.id.chkMonday);
        chkTuesday = findViewById(R.id.chkTuesday);
        chkWednesday = findViewById(R.id.chkWednesday);
        chkThursday = findViewById(R.id.chkThursday);
        chkFriday = findViewById(R.id.chkFriday);
        chkSaturday = findViewById(R.id.chkSaturday);
        chkSunday = findViewById(R.id.chkSunday);

        submit = findViewById(R.id.btnVolunteerSubmit);

        ArrayList<Object> volunteerOptions = new ArrayList<>();
        ArrayList<Object> volunteerDays = new ArrayList<>();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkFoodBank.isChecked())
                {
                    volunteerOptions.add(chkFoodBank.getText().toString());
                }
                if (chkAnimalHandling.isChecked())
                {
                    volunteerOptions.add(chkAnimalHandling.getText().toString());
                }
                if (chkCleanUp.isChecked())
                {
                    volunteerOptions.add(chkCleanUp.getText().toString());
                }
                if (chkMonday.isChecked())
                {
                    volunteerDays.add(chkMonday.getText().toString());
                }
                if (chkTuesday.isChecked())
                {
                    volunteerDays.add(chkTuesday.getText().toString());
                }
                if (chkWednesday.isChecked())
                {
                    volunteerDays.add(chkWednesday.getText().toString());
                }
                if (chkThursday.isChecked())
                {
                    volunteerDays.add(chkThursday.getText().toString());
                }
                if (chkFriday.isChecked())
                {
                    volunteerDays.add(chkFriday.getText().toString());
                }
                if (chkSaturday.isChecked())
                {
                    volunteerDays.add(chkSaturday.getText().toString());
                }
                if (chkSunday.isChecked())
                {
                    volunteerDays.add(chkSunday.getText().toString());
                }

                StringBuilder volOptions = new StringBuilder();
                StringBuilder volDays = new StringBuilder();

                for (int i=0; i < volunteerOptions.size();i++){
                    volOptions.append(volunteerOptions.get(i));
                }

                for (int i=0; i < volunteerDays.size();i++){
                    volDays.append(volunteerDays.get(i));
                }

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                Map<String, Object> data = new HashMap<>();

                data.put("Volunteer Options", volOptions.toString());
                data.put("Days Available", volDays.toString());

                String id = UUID.randomUUID().toString();

                db.collection("Volunteer Form").document(id).set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(VolunteerActivity.this, "Task successful. Form has been submitted", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(VolunteerActivity.this, HomeActivity.class);
                                startActivity(intent);

                            }
                        });
            }
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
                    Intent intent = new Intent(VolunteerActivity.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(VolunteerActivity.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Appointments)
                {
                    Intent intent = new Intent(VolunteerActivity.this, AppointmentsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Log_Out)
                {
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    mAuth.signOut();
                    Intent intent = new Intent(VolunteerActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (itemId == R.id.nav_Comm_Chat)
                {
                    Intent intent = new Intent(VolunteerActivity.this,CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Photos)
                {
                    Intent intent = new Intent(VolunteerActivity.this,Photos1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer)
                {
                    Intent intent = new Intent(VolunteerActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_About)
                {
                    Intent intent = new Intent(VolunteerActivity.this, About1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Account)
                {
                    Intent intent = new Intent(VolunteerActivity.this, Account.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
        popupMenu.show();
    }
    }