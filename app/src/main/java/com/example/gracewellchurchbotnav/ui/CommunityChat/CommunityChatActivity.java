package com.example.gracewellchurchbotnav.ui.CommunityChat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gracewellchurchbotnav.R;

import com.example.gracewellchurchbotnav.ui.JoinMinistry.AssistantInternshipActivity;
import com.example.gracewellchurchbotnav.ui.JoinMinistry.GTeamActivity;
import com.example.gracewellchurchbotnav.ui.JoinMinistry.JoinMinistryActivity;
import com.example.gracewellchurchbotnav.ui.JoinMinistry.SongsterActivity;
import com.example.gracewellchurchbotnav.ui.Volunteer.VolunteerActivity;
import com.example.gracewellchurchbotnav.ui.donations.DonationsActivity;
import com.example.gracewellchurchbotnav.ui.utils.FirebaseUtil;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CommunityChatActivity extends AppCompatActivity {
    RecyclerView recyclerView = findViewById(R.id.CommChatRecyclerView);
    Button btnCreatePost;
    CommChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_chat);



        btnCreatePost = findViewById(R.id.btnCommChatCreatePost);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Query query = db.collection("CommChatPosts").orderBy("Time Posted", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<CommChatData> options = new FirestoreRecyclerOptions.Builder<CommChatData>()
                .setQuery(query, CommChatData.class)
                .build();

        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommunityChatActivity.this, CreateCommunityChatPost.class);
                startActivity(intent);
            }
        });

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
                if (itemID == R.id.txtGteam){
                    Intent intent = new Intent(CommunityChatActivity.this, GTeamActivity.class);
                    startActivity(intent);
                }
                if (itemID == R.id.txtSongster || itemID == R.id.btnGTeamNext){
                    Intent intent = new Intent(CommunityChatActivity.this, SongsterActivity.class);
                    startActivity(intent);
                }
                if (itemID == R.id.txtAssInt){
                    Intent intent = new Intent(CommunityChatActivity.this, AssistantInternshipActivity.class);
                    startActivity(intent);
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
                    Intent intent = new Intent(CommunityChatActivity.this, DonationsActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Join_Us)
                {
                    Intent intent = new Intent(CommunityChatActivity.this, JoinMinistryActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Comm_Chat){
                    Intent intent = new Intent(CommunityChatActivity.this, CommunityChatActivity.class);
                    startActivity(intent);
                    return true;
                }
                if (itemId == R.id.nav_Volunteer){
                    Intent intent = new Intent(CommunityChatActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (adapter!=null){
            adapter.startListening();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        if (adapter!=null){
            adapter.stopListening();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (adapter!=null){
            adapter.startListening();
        }
    }
}