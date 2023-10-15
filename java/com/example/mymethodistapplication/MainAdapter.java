package com.example.mymethodistapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModel model) {
        holder.eventName.setText(model.getEventName());
        holder.eventDate.setText(model.getEventDate());
        holder.eventTime.setText(model.getEventTime());
        holder.eventLocation.setText(model.getEventLocation());


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);

        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView eventName;
        TextView eventDate;
        TextView eventTime;
        TextView eventLocation;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = (TextView) itemView.findViewById(R.id.eEventName);
            eventDate = (TextView) itemView.findViewById(R.id.eEventDate);
            eventTime = (TextView) itemView.findViewById(R.id.eEventTime);
            eventLocation = (TextView) itemView.findViewById(R.id.eEventLocation);

        }
    }
}
