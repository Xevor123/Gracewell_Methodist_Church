package com.example.mymethodistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.mymethodistapplication.databinding.ActivityChooseLanguageBinding;
import com.example.mymethodistapplication.databinding.ActivityHelpBinding;
import com.example.mymethodistapplication.databinding.ActivityNotificationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends AppCompatActivity {

    private CheckBox emailNotificationsCheckbox;
    private CheckBox inAppNotificationsCheckbox;

    BottomNavigationView bottomNavigationView;
    ActivityNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        emailNotificationsCheckbox = findViewById(R.id.emailNotificationsCheckbox);
        inAppNotificationsCheckbox = findViewById(R.id.inAppNotificationsCheckbox);

        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setLabelVisibilityMode(bottomNavigationView.LABEL_VISIBILITY_LABELED);

        // Load user preferences and set the checkbox states accordingly
        // You can retrieve these preferences from SharedPreferences or any other storage method.
        // For example, if SharedPreferences is used:

        boolean receiveEmailNotifications = false; // Load from SharedPreferences
        boolean receiveInAppNotifications = false; // Load from SharedPreferences


        emailNotificationsCheckbox.setChecked(receiveEmailNotifications);
        inAppNotificationsCheckbox.setChecked(receiveInAppNotifications);

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
            } else if (item.getItemId() == R.id.home_nav) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(0, 0);
                return true;

            }


            return false;
        });

    }

    public void saveNotificationPreferences(View view) {
        boolean receiveEmailNotifications = emailNotificationsCheckbox.isChecked();
        boolean receiveInAppNotifications = inAppNotificationsCheckbox.isChecked();

        // Save these preferences, e.g., to SharedPreferences or your server
        // Update the user's notification preferences as needed

        Toast.makeText(this, "Notification preferences saved", Toast.LENGTH_SHORT).show();

    }

    private void showPopupMenu (BottomNavigationView bottomNavView){
        PopupMenu popupMenu = new PopupMenu(this, bottomNavView, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Set up a listener for the items in the popup menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();


                if (itemId == R.id.nav_Donations) {
                    return true;
                }
                if (itemId == R.id.nav_Join_Us) {
                    Intent intent = new Intent(Notification.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Appointments) {
                    Intent intent = new Intent(Notification.this, AppointmentsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Log_Out) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                    return true;
                }
                if (itemId == R.id.nav_Comm_Chat) {
                    return true;
                }
                if (itemId == R.id.nav_Photos) {
                    return true;
                }
                if (itemId == R.id.nav_Volunteer) {
                    return true;
                }
                if (itemId == R.id.nav_About) {
                    Intent intent = new Intent(Notification.this, ChooseLanguage.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Account) {
                    return true;
                }


                return false;
            }
        });
        popupMenu.show();
    }
}