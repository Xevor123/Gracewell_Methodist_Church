package com.example.gracewellchurchbotnav.ui.CommunityChat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gracewellchurchbotnav.R;

import org.w3c.dom.Text;

public class CommChatCommentAdapter extends RecyclerView.Adapter /*extends firebase database(recycler adapter - Comm Chat DB, CommChatAdapter.CommChatViewHolder)*/ {

    Context context;

    public CommChatCommentAdapter(/* @NonNull FirebaseDatabase-RecyclerOptions<CommChatComments> options,*/Context context) {
        this.context = context;
    }

    public void onBindViewHolder(@NonNull CommChatCommentViewHolder holder, int position, @NonNull CommChatComment comment)
    {
        holder.author.setText(comment.getText());
        holder.postedTime.setText(comment.getText());
        holder.content.setText(comment.getText());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CommChatCommentViewHolder extends RecyclerView.ViewHolder{

        TextView author;
        TextView postedTime;
        TextView content;

        public CommChatCommentViewHolder(@NonNull View itemView) {
            super(itemView);

            author = itemView.findViewById(R.id.txtComAuthor);

            postedTime = itemView.findViewById(R.id.txtComPostedTime);

            content = itemView.findViewById(R.id.txtComContent);
        }
    }
}
