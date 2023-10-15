package com.example.mymethodistapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {

    public static String currentUserId(){
        return FirebaseAuth.getInstance().getUid();
    }

    public static CollectionReference CommPostCollectionReference(){
        return FirebaseFirestore.getInstance().collection("CommChatPosts");
    }

    public static DocumentReference getChatroomReference(String chatroomId){
        return FirebaseFirestore.getInstance().collection("CommChatPosts").document(chatroomId);
    }

    public static DocumentReference getCommentID(String commentId){
        return FirebaseFirestore.getInstance().collection("Comments").document(commentId);
    }

    public static CollectionReference getCommentReference(String chatroomId){
        return getChatroomReference(chatroomId).collection("chats");
    }

}
