package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.ads.AdFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nir on 26/02/17.
 */

@Module
public class AdFactoryModule {

    @Provides
    public AdFactory provideAdFactory() {
        return new AdFactory();
    }
}
