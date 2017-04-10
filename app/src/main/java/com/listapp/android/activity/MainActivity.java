package com.listapp.android.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.listapp.android.R;
import com.listapp.android.model.bo.GeneralBO;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GeneralBO.getInstance().getCityWeather("3128759");

    }

    // move this to control to an notification class
    private void showServerProblem() {
        Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();

    }
}
