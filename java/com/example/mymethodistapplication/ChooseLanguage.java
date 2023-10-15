package com.example.mymethodistapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymethodistapplication.databinding.ActivityChooseLanguageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.mymethodistapplication.databinding.ActivityAbout1Binding;
import com.example.mymethodistapplication.databinding.ActivityChooseLanguageBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ChooseLanguage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ActivityChooseLanguageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);

        binding = ActivityChooseLanguageBinding.inflate(getLayoutInflater());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setLabelVisibilityMode(bottomNavigationView.LABEL_VISIBILITY_LABELED);

        LanguageManager lang = new LanguageManager(this);

        TextView afrikaanstext = findViewById(R.id.afrikaanstext);
        afrikaanstext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang.updateResource("af");
                recreate();
            }
        });


        TextView englishtext = findViewById(R.id.englishtext);
        englishtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang.updateResource("en");
                recreate();
            }
        });


        TextView zulustext = findViewById(R.id.zulutext);
        zulustext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang.updateResource("zu");
                recreate();
            }
        });

        TextView spanishtext = findViewById(R.id.spanishtext);
        spanishtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang.updateResource("es");
                recreate();
            }
        });
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
                    Intent intent = new Intent(ChooseLanguage.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(ChooseLanguage.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Appointments)
                {
                    Intent intent = new Intent(ChooseLanguage.this, AppointmentsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Log_Out)
                {
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    mAuth.signOut();
                    Intent intent = new Intent(ChooseLanguage.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (itemId == R.id.nav_Comm_Chat)
                {
                    Intent intent = new Intent(ChooseLanguage.this,CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Photos)
                {
                    Intent intent = new Intent(ChooseLanguage.this,Photos1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer)
                {
                    Intent intent = new Intent(ChooseLanguage.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_About)
                {
                    Intent intent = new Intent(ChooseLanguage.this, About1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Account)
                {
                    Intent intent = new Intent(ChooseLanguage.this, Account.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
        popupMenu.show();
    }
}