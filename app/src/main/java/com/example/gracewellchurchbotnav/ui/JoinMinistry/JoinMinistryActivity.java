package com.example.gracewellchurchbotnav.ui.JoinMinistry;

import android.content.Intent;
import android.os.Bundle;

import com.example.gracewellchurchbotnav.ui.CommunityChat.CommunityChatActivity;
import com.example.gracewellchurchbotnav.ui.Volunteer.VolunteerActivity;
import com.example.gracewellchurchbotnav.ui.donations.DonationsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.MenuItem;
import android.widget.PopupMenu;

import com.example.gracewellchurchbotnav.R;

public class JoinMinistryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_min_main);

        if (findViewById(R.id.main_activity) != null) {
            if (savedInstanceState != null) {
                return;
            }

            // Create a new fragment instance
            JoinMinistryMainFragment myFragment = new JoinMinistryMainFragment();

            // Add the fragment to the container
            getSupportFragmentManager().beginTransaction().add(R.id.main_activity, myFragment).commit();
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
                    Intent intent = new Intent(JoinMinistryActivity.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(JoinMinistryActivity.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Comm_Chat){
                    Intent intent = new Intent(JoinMinistryActivity.this, CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer){
                    Intent intent = new Intent(JoinMinistryActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

}