package com.example.marymbuvi.eventbookingapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by Mary Mbuvi on 5/3/2018.
 */

public class ImageAdapter extends BaseAdapter{
    Context mContext;
    int images[] = {
            R.mipmap.event1,
            R.mipmap.event2,
            R.mipmap.event3,
            R.mipmap.event5
    };

    public ImageAdapter(Context mContext){
        this.mContext = mContext;
    }
    public int getCount() {
        return images.length;
    }
    public Object getItem(int position) {
        return images[position];
    }
    public long getItemId(int position){
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
}
