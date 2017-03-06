package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.ui.MainActivity;

import dagger.Component;

/**
 * Created by nir on 05/03/17.
 */
@Component(modules = {RandomStringFactoryModule.class, NetworkClientModule.class})
public interface AppComponent {
    void inject (MainActivity mainActivity);

}
