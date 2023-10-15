package com.example.mymethodistapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.ViewHolder> {

    private static final String Tage = "RecyclerView";
    private Context mContext;
    private ArrayList<Messages> messagesArrayList;

    public RecyclerAdpater(Context mContext, ArrayList<Messages> messagesArrayList) {
        this.mContext = mContext;
        this.messagesArrayList = messagesArrayList;
    }




    @NonNull
    @Override
    public RecyclerAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(messagesArrayList.get(position).getName());

        Glide.with(mContext).load(messagesArrayList.get(position).getImageUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewp);
            textView = itemView.findViewById(R.id.textViewp);
        }
    }

}
