package com.listapp.android.activity;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by ivan on 4/10/2017.
 */

public class ApplicationController extends Application {

    private Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        // INITIALIZATION
        applicationContext = getApplicationContext();

    }

    public Context getApplicationContext() {
        return applicationContext;
    }



    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}



