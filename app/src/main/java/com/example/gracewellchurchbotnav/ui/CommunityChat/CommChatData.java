package com.example.gracewellchurchbotnav.ui.CommunityChat;

public class CommChatData {

    String title;
    String description;
    String chatType;
    int commentNumber;
    String author;
    String lastActive;
    String firstPosted;

    public CommChatData(String title, String description, String chatType, int commentNumber, String author, String lastActive, String firstPosted) {
        this.title = title;
        this.description = description;
        this.chatType = chatType;
        this.commentNumber = commentNumber;
        this.author = author;
        this.lastActive = lastActive;
        this.firstPosted = firstPosted;
    }

    public String getFirstPosted() {
        return firstPosted;
    }

    public void setFirstPosted(String firstPosted) {
        this.firstPosted = firstPosted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLastActive() {
        return lastActive;
    }

    public void setLastActive(String lastActive) {
        this.lastActive = lastActive;
    }
}
