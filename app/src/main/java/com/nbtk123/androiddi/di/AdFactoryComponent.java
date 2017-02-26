package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.ads.AdFactory;
import com.nbtk123.androiddi.ui.MainActivity;

import dagger.Component;

/**
 * Created by nir on 26/02/17.
 */

@Component(modules = {AdFactoryModule.class})
public interface AdFactoryComponent {
    void inject(MainActivity activity);

    AdFactory provideAdFactory();
}
