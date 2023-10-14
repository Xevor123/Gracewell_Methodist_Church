package com.example.gracewellchurchbotnav.ui.CommunityChat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gracewellchurchbotnav.R;
import com.example.gracewellchurchbotnav.ui.utils.FirebaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreateCommunityChatPost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private DatabaseReference GracewellComChatDB;

    FirebaseAuth mAuth;

    EditText txtSubject;
    Spinner spnPostType;
    String postType;
    EditText txtContent;
    int comment;
    String postDate;
    String author;
    int chatID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_community_chat_post);

        txtSubject = findViewById(R.id.txtSubject);

        spnPostType = (Spinner) findViewById(R.id.spnPostType);
        spnPostType.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPostType.setAdapter(adapter);

        txtContent = findViewById(R.id.txtContent);

        Button postChat = (Button) findViewById(R.id.postChat);

        postChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (txtSubject.getText() != null || txtContent.getText() != null|| postType != null) {

                }
                else {

                }
            }
        });
    }

    void setChat(){
        String title = txtSubject.toString();
        String type = postType;
        String content = txtContent.toString();
        int comment = 0;
        String commAuthor = author.toString();
        String chatID = UUID.randomUUID().toString();
        LocalDateTime date = LocalDateTime.now();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentDate = simpleDate.format(date);
        String authId = mAuth.getInstance().getUid();

        Map<String, Object> chat = new HashMap<>();
        chat.put("Title", title);
        chat.put("Post Type", type);
        chat.put("Content", content);
        chat.put("Comment Number", comment);
        chat.put("Author", commAuthor);
        chat.put("Author Id", authId);
        chat.put("Time Posted", currentDate);


        db.collection("CommChatPosts").document(chatID).set(chat)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Intent intent = new Intent(CreateCommunityChatPost.this, CommunityChatActivity.class);
                        startActivity(intent);
                    }
                });
    }

    public void onItemSelected(AdapterView arg0, View arg1, int position, long id)
    {
        postType = spnPostType.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView arg0)
    {

    }
}