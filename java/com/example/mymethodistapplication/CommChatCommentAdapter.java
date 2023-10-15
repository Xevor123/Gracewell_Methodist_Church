package com.example.mymethodistapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CommChatCommentAdapter extends FirestoreRecyclerAdapter<ChatCommentData, CommChatCommentAdapter.CommentDataViewHolder> {

    Context context;

    public CommChatCommentAdapter(@NonNull FirestoreRecyclerOptions<ChatCommentData> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull CommentDataViewHolder holder, int position, @NonNull ChatCommentData data) {
        LocalDateTime currentTime = LocalDateTime.now();

        Duration duration = Duration.between(data.getTimestamp(), currentTime);

        ZoneId zoneId =ZoneId.systemDefault();
        ZonedDateTime startDate = data.getTimestamp().atZone(zoneId);
        ZonedDateTime endDate = currentTime.atZone(zoneId);
        Period period = Period.between(startDate.toLocalDate(), endDate.toLocalDate());

        String elapsedTime = "";

        if (period.getYears()>0){
            if (period.getYears()==1){
                elapsedTime = period.getYears() + " Year Ago";
            }
            else{
                elapsedTime = period.getYears() + " Years Ago";
            }
        }
        else {
            if (period.getMonths()>0){
                if (period.getMonths()==1){
                    elapsedTime = period.getYears() + " Month Ago";
                }
                else {
                    elapsedTime = period.getYears() + " Months Ago";
                }
            }
            else {
                if (period.getDays()>0){
                    if (period.getDays() == 1){
                        elapsedTime = period.getDays() + " Day Ago";
                    }
                    else {
                        elapsedTime = period.getDays() + " Days Ago";
                    }
                }
                else{
                    if (duration.toHours()>0){
                        if (duration.toHours() == 1){
                            elapsedTime = period.getDays() + " Hour Ago";
                        }
                        else{
                            elapsedTime = period.getDays() + " Hour Ago";
                        }
                    }
                    else {
                        if (duration.toMinutes()%60 > 0){
                            if (duration.toMinutes()%60 == 1){
                                elapsedTime = period.getDays() + " Minute Ago";
                            }
                            else {
                                elapsedTime = period.getDays() + " Minutes Ago";
                            }
                        }
                        else {
                            if (duration.getSeconds()%60>0){
                                if (duration.getSeconds()%60 == 1){
                                    elapsedTime = period.getDays() + " Second Ago";
                                }
                                else {
                                    elapsedTime = period.getDays() + " Seconds Ago";
                                }
                            }
                        }
                    }
                }
            }
        }

        holder.commentAuthor.setText(data.getCommenter());
        holder.commentContent.setText(data.getComment());
        holder.commentTime.setText(elapsedTime);

    }

    @NonNull
    @Override
    public CommentDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_comm_chat_comment_card,parent,false);
        return new CommentDataViewHolder(view);
    }

    static class CommentDataViewHolder extends RecyclerView.ViewHolder{
        TextView commentContent;
        TextView commentAuthor;
        TextView commentTime;

        public CommentDataViewHolder(@NonNull View itemView){
            super(itemView);
            commentContent = itemView.findViewById(R.id.txtCommChatContent);
            commentAuthor = itemView.findViewById(R.id.txtCommChatAuthor);
            commentTime = itemView.findViewById(R.id.txtCommChatActive);
        }

    }
}
