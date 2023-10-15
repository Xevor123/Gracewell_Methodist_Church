package com.example.mymethodistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.mymethodistapplication.databinding.ActivityContactUsBinding;
import com.example.mymethodistapplication.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ContactUs extends AppCompatActivity {

    ActivityContactUsBinding binding;
    BottomNavigationView bottomNavigationView;

    Button CreateAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        binding = ActivityContactUsBinding.inflate(getLayoutInflater());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.contactus_nav);
        bottomNavigationView.setLabelVisibilityMode(bottomNavigationView.LABEL_VISIBILITY_LABELED);

        CreateAppointment =(Button) findViewById(R.id.CreateAppointment);
        CreateAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppointmentActivity();
            }
        });


        WebView webView = findViewById(R.id.webView5);
        String map = "<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14359.597479911263!2d28.2333461!3d-25.8727892!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x1e956646d90020b7%3A0xa50c05903bbfbc78!2sCornwall%20Hill%20College!5e0!3m2!1sen!2sza!4v1691664224845!5m2!1sen!2sza\" width=\"100%\" height=\"100%\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>";
        webView.loadData(map,"text/html","utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

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
                    Intent intent = new Intent(ContactUs.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(ContactUs.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Appointments)
                {
                    Intent intent = new Intent(ContactUs.this, AppointmentsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Log_Out)
                {
                    FirebaseAuth mAuth = FirebaseAuth.getInstance();
                    mAuth.signOut();
                    Intent intent = new Intent(ContactUs.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (itemId == R.id.nav_Comm_Chat)
                {
                    Intent intent = new Intent(ContactUs.this,CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Photos)
                {
                    Intent intent = new Intent(ContactUs.this,Photos1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer)
                {
                    Intent intent = new Intent(ContactUs.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_About)
                {
                    Intent intent = new Intent(ContactUs.this, About1.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Account)
                {
                    Intent intent = new Intent(ContactUs.this, Account.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
        popupMenu.show();
    }

    private void openAppointmentActivity() {
        Intent intent = new Intent(this,AppointmentsActivity.class);
        startActivity(intent);
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.frame_layout);
        fragmentTransaction.commit();
    }

}