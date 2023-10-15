package com.example.mymethodistapplication;

import android.content.Context;
import android.content.Intent;
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

public class CommChatAdapter extends FirestoreRecyclerAdapter<CommChatData, CommChatAdapter.CommChatDataViewHolder> {

    Context context;

    public CommChatAdapter(@NonNull FirestoreRecyclerOptions<CommChatData> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull CommChatDataViewHolder holder, int position, @NonNull CommChatData data) {
        LocalDateTime currentTime = LocalDateTime.now();

        Duration duration = Duration.between(data.getPostedTime(), currentTime);

        ZoneId zoneId =ZoneId.systemDefault();
        ZonedDateTime startDate = data.getPostedTime().atZone(zoneId);
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
                    elapsedTime = period.getMonths() + " Month Ago";
                }
                else {
                    elapsedTime = period.getMonths() + " Months Ago";
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
                        elapsedTime = duration.toHours() + " Hour Ago";
                    }
                    else {
                        if (duration.toMinutes()%60 > 0){
                            if (duration.toMinutes()%60 == 1){
                                elapsedTime = duration.toMinutes() + " Minute Ago";
                            }
                            else {
                                elapsedTime = duration.toMinutes() + " Minutes Ago";
                            }
                        }
                        else {
                            if (duration.getSeconds()>0){
                                if (duration.getSeconds() == 1){
                                    elapsedTime = duration.getSeconds() + " Second Ago";
                                }
                                else {
                                    elapsedTime = duration.getSeconds() + " Seconds Ago";
                                }
                            }
                        }
                    }
                }
            }
        }

        holder.comTitle.setText(data.getTitle());
        holder.comType.setText(data.getType());
        holder.comContent.setText(data.getContent());
        holder.comAuthor.setText(data.getAuthor().substring(0, data.getAuthor().indexOf("@")));
        holder.comCommentNumber.setText(data.getCommentNumber());
        holder.comTime.setText(elapsedTime);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CommunityChatView.class);
            CommChatUtil.passCommChatDataAsIntent(intent, data);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public CommChatDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_comm_chat_row,parent,false);
        return new CommChatDataViewHolder(view);
    }

    static class CommChatDataViewHolder extends RecyclerView.ViewHolder{
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
