package com.nbtk123.androiddi;

import android.app.Application;

import com.nbtk123.androiddi.di.AppComponent;
import com.nbtk123.androiddi.di.DaggerAppComponent;

/**
 * Created by nir on 26/02/17.
 */

public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }
}
