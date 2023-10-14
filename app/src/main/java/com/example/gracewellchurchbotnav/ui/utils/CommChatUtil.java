package com.example.gracewellchurchbotnav.ui.utils;

import android.content.Intent;

import com.example.gracewellchurchbotnav.ui.CommunityChat.CommChatData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Objects;

public class CommChatUtil {

    public static void passCommChatDataAsIntent(Intent intent, CommChatData data){
        intent.putExtra("Title", data.getTitle());
        intent.putExtra("Post Type", data.getType());
        intent.putExtra("Content", data.getContent());
        intent.putExtra("Author", data.getAuthor());
        intent.putExtra("Author Id", data.getAuthId());
        intent.putExtra("Comment Number", data.getCommentNumber());
        intent.putExtra("Time Posted", data.getPostedTime());
        intent.putExtra("Chat Id", data.getChatId());
    }

    public static CommChatData getCommChatDataFromIntent(Intent intent) {
        CommChatData data = new CommChatData();
        data.setChatId(intent.getStringExtra("Chat Id"));
        data.setAuthor(intent.getStringExtra("Author"));
        data.setAuthId(intent.getStringExtra("Auhtor Id"));
        data.setContent(intent.getStringExtra("Content"));
        data.setType(intent.getStringExtra("Post Type"));
        data.setTitle(intent.getStringExtra("Title"));
        data.setCommentNumber(intent.getIntExtra("Comment Number", 0));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        data.setPostedTime(LocalDateTime.parse(intent.getStringExtra("Time Posted")));
        return data;
    }

}
