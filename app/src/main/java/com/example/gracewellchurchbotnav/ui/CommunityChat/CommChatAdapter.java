package com.example.gracewellchurchbotnav.ui.CommunityChat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gracewellchurchbotnav.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class CommChatAdapter extends FirestoreRecyclerAdapter<CommChatData, CommChatAdapter.CommChatDataViewHolder> {

    Context context;

    public CommChatAdapter(@NonNull FirestoreRecyclerOptions<CommChatData> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull CommChatDataViewHolder holder, int position, @NonNull CommChatData data) {
        holder.comTitle.setText(data.getTitle());
        holder.comType.setText(data.getType());
        holder.comContent.setText(data.getContent());
        holder.comAuthor.setText(data.getContent());
        holder.comCommentNumber.setText(data.getCommentNumber());
        holder.comTime.setText(data.getPostedTime().toString());
    }

    @NonNull
    @Override
    public CommChatDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_comm_chat_row,parent,false);
        return new CommChatDataViewHolder(view);
    }

    class CommChatDataViewHolder extends RecyclerView.ViewHolder{
        TextView comTitle;
        TextView comType;
        TextView comContent;
        TextView comAuthor;
        TextView comTime;
        TextView comCommentNumber;

        public CommChatDataViewHolder(@NonNull View itemView){
            super(itemView);
            comTitle = itemView.findViewById(R.id.txtCommChatTitle);
            comType = itemView.findViewById(R.id.txtCommChatType);
            comContent = itemView.findViewById(R.id.txtCommChatContent);
            comAuthor = itemView.findViewById(R.id.txtCommChatAuthor);
            comTime = itemView.findViewById(R.id.txtCommChatActive);
            comCommentNumber = itemView.findViewById(R.id.txtCommChatCommentCount);
        }

    }
}
