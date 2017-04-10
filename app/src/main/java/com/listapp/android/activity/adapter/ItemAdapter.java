package com.listapp.android.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.listapp.android.R;
import com.listapp.android.model.openweathermap.WeatherData;
import com.listapp.android.model.openweathermap.WeatherList;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<WeatherList> {
    public ItemAdapter(Context context, ArrayList<WeatherList> weatherLists) {
        super(context, 0, weatherLists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        WeatherList weatherList = getItem(position);

        // TODO use a holder view
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        // Lookup view for data population
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);


        if(weatherList.getWeather().length >0) {
        // Populate the data into the template view using the data object
        textView.setText(weatherList.getDt_txt());
            WeatherData weatherData = weatherList.getWeather()[0];
            textView2.setText(weatherData.getDescription());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}