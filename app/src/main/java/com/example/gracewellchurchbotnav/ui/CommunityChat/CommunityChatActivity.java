package com.example.gracewellchurchbotnav.ui.CommunityChat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gracewellchurchbotnav.R;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CommunityChatActivity extends AppCompatActivity {

    Button btnCreatePost;
    RecyclerView recyclerView;
    CommChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_chat);

        btnCreatePost = findViewById(R.id.btnCommChatCreatePost);
        recyclerView = findViewById(R.id.CommChatRecyclerView);

        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommunityChatActivity.this, CreateCommunityChatPost.class);
                startActivity(intent);
            }
        });
    }

    void setupCommChatRecyclerView(){
        adapter = new CommChatAdapter(, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.startListening();
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