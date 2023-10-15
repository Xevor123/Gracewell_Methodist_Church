package com.example.mymethodistapplication;

import java.time.LocalDateTime;
import java.util.Date;

public class CommChatData {
    private String author;
    private String title;
    private String content;
    private String type;
    private int commentNumber;
    private LocalDateTime postedTime;
    private String chatId;
    private String authId;

    public CommChatData() {
    }

    public CommChatData(String author, String title, String content, String type, int commentNumber, LocalDateTime postedTime, String chatId, String authId) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.type = type;
        this.commentNumber = commentNumber;
        this.postedTime = postedTime;
        this.chatId = chatId;
        this.authId = authId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatID) {
        this.chatId = chatID;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }
}
