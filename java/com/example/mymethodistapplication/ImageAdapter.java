package com.example.mymethodistapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private List<String> imageUrls;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return imageUrls != null ? imageUrls.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return imageUrls != null ? imageUrls.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.grid_item, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String imageUrl = (String) getItem(position);
        Picasso.get().load(imageUrl).into(viewHolder.imageView);

        return view;
    }

    private static class ViewHolder {
        ImageView imageView;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.gridItemImageView);
        }
    }
}
