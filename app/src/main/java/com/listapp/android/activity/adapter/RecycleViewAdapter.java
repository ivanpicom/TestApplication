package com.listapp.android.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.listapp.android.R;
import com.listapp.android.model.openweathermap.WeatherData;
import com.listapp.android.model.openweathermap.WeatherList;

import java.util.ArrayList;

/**
 * Created by ivan on 4/11/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private ArrayList<WeatherList> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView textView2;

        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);

            // Lookup view for data population
             textView = (TextView) v.findViewById(R.id.textView);
             textView2 = (TextView) v.findViewById(R.id.textView2);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecycleViewAdapter(ArrayList<WeatherList> weatherListArrayAdapter) {
        mDataset = weatherListArrayAdapter;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        WeatherList weatherList = mDataset.get(position);//getItem(position);

        if(weatherList.getWeather().length >0) {
            // Populate the data into the template view using the data object
            holder.textView.setText(weatherList.getDt_txt());
            WeatherData weatherData = weatherList.getWeather()[0];
            holder.textView2.setText(weatherData.getDescription());
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}