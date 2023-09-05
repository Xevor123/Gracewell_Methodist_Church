package com.example.gracewellchurchbotnav.ui.CommunityChat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gracewellchurchbotnav.R;
import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCommunityChatPost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseReference GracewellComChatDB;

    EditText txtSubject;
    Spinner spnPostType;
    String postType;
    EditText txtContent;
    int comment;
    String postDate;
    String author;

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
                    txtSubject.getText();
                    txtContent.getText();
                    comment = 0;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
                    postDate = simpleDateFormat.format(new Date());
                    author = "";


                }
                else {

                }
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