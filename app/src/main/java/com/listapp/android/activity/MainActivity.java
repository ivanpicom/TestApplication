package com.listapp.android.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.listapp.android.R;
import com.listapp.android.view.WeatherListView;
import com.listapp.android.activity.adapter.ItemAdapter;
import com.listapp.android.model.openweathermap.WeatherGlobalData;
import com.listapp.android.model.openweathermap.WeatherList;
import com.listapp.android.presenter.DataItemInteractorImpl;
import com.listapp.android.presenter.DataItemPresenter;

import java.util.ArrayList;

public class MainActivity extends BasicActivity implements WeatherListView{

    private ArrayList<WeatherList> weatherLists;
    private ItemAdapter adapter;
    private DataItemInteractorImpl interactor;
    private DataItemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        weatherLists = new ArrayList<WeatherList>();
        // Create the adapter to convert the array to views
        adapter = new ItemAdapter(this, weatherLists);

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lt_main_activity);
        listView.setAdapter(adapter);

        DataItemInteractorImpl interactor = new DataItemInteractorImpl();
        presenter = new DataItemPresenter(interactor);
        presenter.bind(this);

        presenter.prefomDataWeather("3128758");

    }

    // move this to control to an notification class
    private void showServerProblem() {
        Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updateUi(WeatherGlobalData weatherGlobalData) {

        if(weatherGlobalData != null) {
            adapter.clear();
            for (WeatherList weatherList : weatherGlobalData.getList()) {
                adapter.add(weatherList);
            }
        }
        else {
            // TODO error to update query
        }



    }
}
