package com.example.mymethodistapplication;

import com.google.firebase.Timestamp;

import java.time.LocalDateTime;
import java.util.List;

public class ChatCommentData {
    String chatID;
    String commentID;
    LocalDateTime timestamp;
    String commenter;
    String comment;

    public ChatCommentData() {
    }

    public ChatCommentData(String chatID, String commentID, LocalDateTime timestamp, String commenter, String comment) {
        this.chatID = chatID;
        this.commentID = commentID;
        this.timestamp = timestamp;
        this.commenter = commenter;
        this.comment = comment;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
