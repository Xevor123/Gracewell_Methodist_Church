package com.example.mymethodistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreateCommunityChatPost extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth;

    private EditText txtSubject;
    private EditText txtContent;
    private String title;
    private String type;
    private String content;
    private int comment = 0;
    private String commAuthor;
    private String chatID;
    private String author = "YourAuthorValue"; // Initialize author with a valid value.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_community_chat_post);

        mAuth = FirebaseAuth.getInstance();

        txtSubject = findViewById(R.id.txtSubject);
        txtContent = findViewById(R.id.txtContent);
        RadioGroup btnTypes = findViewById(R.id.btgrPostType);
        Button postChat = findViewById(R.id.postChat);

        postChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChat();
            }
        });
    }

    void setChat() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            author = user.getEmail().substring(0, user.getEmail().indexOf("@"));
        }

        RadioGroup btnTypes = findViewById(R.id.btgrPostType);
        int selectID = btnTypes.getCheckedRadioButtonId();
        RadioButton btnSelectedType = findViewById(selectID);

        title = txtSubject.getText().toString();
        type = btnSelectedType.getText().toString();
        content = txtContent.getText().toString();
        commAuthor = author;
        chatID = UUID.randomUUID().toString();
        String authId = mAuth.getCurrentUser().getUid();

        Map<String, Object> chat = new HashMap<>();
        chat.put("Title", title);
        chat.put("Post Type", type);
        chat.put("Content", content);
        chat.put("Comment Number", comment);
        chat.put("Author", commAuthor);
        chat.put("Author Id", authId);
        chat.put("Time Posted", getCurrentDateTime());

        db.collection("ComChatPosts").document(chatID).set(chat)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Intent intent = new Intent(CreateCommunityChatPost.this, CommunityChatActivity.class);
                        startActivity(intent);
                    }
                });
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new java.util.Date());
    }
}
