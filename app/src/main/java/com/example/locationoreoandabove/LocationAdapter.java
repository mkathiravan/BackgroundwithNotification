package com.example.locationoreoandabove;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder>  {

    private static final String TAG = LocationAdapter.class.getSimpleName();

    Context context;
    ArrayList<Location> locationList;

    public LocationAdapter(Context context, ArrayList<Location> locationList) {
        this.context = context;
        this.locationList = locationList;
    }

    @Override
    public LocationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_adapter_item,parent,false);
        return new LocationAdapter.MyViewHolder(v);
    }




    @Override
    public void onBindViewHolder(LocationAdapter.MyViewHolder holder, final int position) {


        holder.textLatitude.setText(String.valueOf(locationList.get(position).getLatitude()));

        holder.textLongitude.setText(String.valueOf(locationList.get(position).getLongitude()));

        Date date = new Date(locationList.get(position).getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        GregorianCalendar gc = new GregorianCalendar();
        String localTime = formatter.format(date.getTime());

        holder.textTime.setText(localTime);

    }





    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.text_latitude)
        TextView textLatitude;
        @BindView(R.id.text_longitude)
        TextView textLongitude;
        @BindView(R.id.text_time)
        TextView textTime;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
