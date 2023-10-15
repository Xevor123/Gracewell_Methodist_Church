package com.example.mymethodistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import com.example.mymethodistapplication.databinding.ActivityAppointmentsBinding;
import com.example.mymethodistapplication.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AppointmentsActivity extends AppCompatActivity {

    ActivityAppointmentsBinding binding;
    BottomNavigationView bottomNavigationView;
    private EditText mEditTextTo;
    private EditText mEditTextMessage;

    private EditText mEditTextSubject;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        binding = ActivityAppointmentsBinding.inflate(getLayoutInflater());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.contactus_nav);
        bottomNavigationView.setLabelVisibilityMode(bottomNavigationView.LABEL_VISIBILITY_LABELED);
        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextMessage = findViewById(R.id.edit_text_message);
        mEditTextSubject = findViewById(R.id.edit_text_subject);

        Button sendMessageButton = findViewById(R.id.sendMessageButton);

        sendMessageButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }

            private void sendMessage() {
                String Message = mEditTextMessage.getText().toString();
                String subject = mEditTextSubject.getText().toString();
                Intent intent = new Intent(Intent.EXTRA_TEXT);
                intent.putExtra(Intent.EXTRA_TEXT, Message);

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://api.whatsapp.com/send?phone=+270646447924&text="+"*"+subject+"*"+ ": " +Message)));
            }
        }));



        Button sendTicketButton = findViewById(R.id.sendTicketButton);
        sendTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }

            private void sendMail() {
                String recipientList = mEditTextTo.getText().toString();
                String[] recipients = recipientList.split(",");

                String Message = mEditTextMessage.getText().toString();
                String subject = mEditTextSubject.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_TEXT, Message);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);

                intent.setType("Message/rfc822");
                startActivity(Intent.createChooser(intent, "choose"));
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
                    Intent intent = new Intent(AppointmentsActivity.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(AppointmentsActivity.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Appointments)
                {
                    Intent intent = new Intent(AppointmentsActivity.this, AppointmentsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Log_Out)
                {
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    mAuth.signOut();
                    Intent intent = new Intent(AppointmentsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (itemId == R.id.nav_Comm_Chat)
                {
                    Intent intent = new Intent(AppointmentsActivity.this,CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Photos)
                {
                    Intent intent = new Intent(AppointmentsActivity.this,Photos1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer)
                {
                    Intent intent = new Intent(AppointmentsActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_About)
                {
                    Intent intent = new Intent(AppointmentsActivity.this, About1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Account)
                {
                    Intent intent = new Intent(AppointmentsActivity.this, Account.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
        popupMenu.show();
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.frame_layout);
        fragmentTransaction.commit();
    }

}

