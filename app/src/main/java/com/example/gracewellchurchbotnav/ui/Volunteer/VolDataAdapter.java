package com.example.gracewellchurchbotnav.ui.Volunteer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gracewellchurchbotnav.R;
import java.util.ArrayList;

public class VolDataAdapter extends RecyclerView.Adapter<VolDataAdapter.ViewHolder>
{
    private final Context context;
    private final ArrayList<VolunteerData> volunteerDataArrayList;

    public VolDataAdapter(Context context, ArrayList<VolunteerData> volunteerDataArrayList) {
        this.context = context;
        this.volunteerDataArrayList = volunteerDataArrayList;
    }

    @NonNull
    @Override
    public VolDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_vol_list_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolDataAdapter.ViewHolder holder, int position)
    {
        VolunteerData volunteerData = volunteerDataArrayList.get(position);
        holder.volImage.setImageResource(volunteerData.getVolImage());
        holder.volArrow.setImageResource(volunteerData.getVolArrow());
        holder.volAddress.setText(volunteerData.getVolAddress());
        holder.volDate.setText(volunteerData.getVolDate());
        holder.volTime.setText(volunteerData.getVolStartTime() + " - " + volunteerData.getVolEndTime());
        holder.volLocation.setText(volunteerData.getVolPlaceName());
        holder.volTitle.setText(volunteerData.getVolOpportunityName());
        holder.volCount.setText(volunteerData.getTotalVolunteers() + "/" + volunteerData.getMaxVolunteers());
    }

    @Override
    public int getItemCount()
    {
        return volunteerDataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView volImage;
        private final TextView volCount;
        private final TextView volTitle;
        private final TextView volAddress;
        private final TextView volLocation;
        private final TextView volDate;
        private final TextView volTime;
        private final ImageView volArrow;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            volImage = itemView.findViewById(R.id.imgVolCount);
            volCount = itemView.findViewById(R.id.lblVolCount);
            volTitle = itemView.findViewById(R.id.lblVolTitle);
            volDate = itemView.findViewById(R.id.lblVolDate);
            volTime = itemView.findViewById(R.id.lblVolTimeFrame);
            volLocation = itemView.findViewById(R.id.lblLocationName);
            volAddress = itemView.findViewById(R.id.lblAddress);
            volArrow = itemView.findViewById(R.id.imgVolArrow);
        }
    }
}