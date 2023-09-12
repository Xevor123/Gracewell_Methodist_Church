package com.example.gracewellchurchbotnav.ui.CommunityChat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.gracewellchurchbotnav.R;

public class CommunityChatView extends AppCompatActivity {

    private static final int PICK_FILE_REQUEST_CODE = 101;
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 102;

    TextView mainTitle;
    TextView mainContent;
    TextView postType;
    TextView commentCount;
    TextView mainAuthor;

    ImageButton report;
    ImageButton send;
    ImageButton emoji;
    ImageButton fileLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_chat_view);

        mainTitle = findViewById(R.id.txtTitle);
        mainContent = findViewById(R.id.txtContent);
        postType = findViewById(R.id.txtPostType);
        commentCount = findViewById(R.id.txtCommentCount);
        mainAuthor = findViewById(R.id.txtAuthor);

        report = findViewById(R.id.btnReport);
        send = findViewById(R.id.btnSendButton);
        emoji = findViewById(R.id.btnEmoji);
        fileLink = findViewById(R.id.btnAttachFile);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        fileLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStoragePermissionGranted()){
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("*/*");
                    startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            // Get the selected file's URI.
            Uri selectedFileUri = data.getData();

            // Now you can handle the selected file, such as uploading it to a server or processing it.
            // Replace the code below with your desired file handling logic.
            if (selectedFileUri != null) {
                String selectedFilePath = selectedFileUri.getPath();
                // Do something with the selected file path.
            }
        }
    }

    // Check and request storage permission if not granted.
    private boolean isStoragePermissionGranted() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION_REQUEST_CODE
            );
            return false;
        }
        return true;
    }

    // Handle permission request result.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can now proceed with file selection.
            } else {
                // Permission denied, handle accordingly (e.g., show a message).
            }
        }
    }
}