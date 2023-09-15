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

import java.util.ArrayList;

public class CommChatAdapter extends RecyclerView.Adapter /*extends firebase database(recycler adapter - Comm Chat DB, CommChatAdapter.CommChatViewHolder)*/{


    Context context;

    public CommChatAdapter(/* @NonNull FirebaseDatabase-RecyclerOptions<CommunityChat> options,*/Context context) {
        //super(options);
        this.context = context;
    }

    public void onBindViewHolder(@NonNull CommChatViewHolder holder, int position, @NonNull CommunityChat chat){
        holder.title.setText(chat.getTitle());
        holder.content.setText(chat.getContent());
        holder.type.setText(chat.getType());
        holder.comCount.setText(chat.getCommentCount());
        holder.author.setText(chat.getAuthor());
        holder.posted.setText(chat.getPosted());
    }


    public CommChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_comm_chat_row,parent,false);
        return new CommChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CommChatViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView content;
        TextView comCount;
        TextView type;
        TextView posted;
        TextView author;

        public CommChatViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtCommChatTitle);
            content = itemView.findViewById(R.id.txtCommChatContent);
            comCount = itemView.findViewById(R.id.txtCommChatCommentCount);
            type = itemView.findViewById(R.id.txtCommChatType);
            posted = itemView.findViewById(R.id.txtCommChatActive);
            author = itemView.findViewById(R.id.txtCommChatAuthor);
        }
    }
}
