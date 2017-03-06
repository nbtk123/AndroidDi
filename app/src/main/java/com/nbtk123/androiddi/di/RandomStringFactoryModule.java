package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.randomstring.RandomStringFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nir on 05/03/17.
 */
@Module
public class RandomStringFactoryModule {

    private RandomStringFactory randomStringFactory;

    public RandomStringFactoryModule() {}

    public RandomStringFactoryModule(RandomStringFactory randomStringFactory) {
        this.randomStringFactory = randomStringFactory;
    }

    @Provides
    RandomStringFactory randomStringFactory() {
        if (randomStringFactory == null) {
            return new RandomStringFactory();
        }

        return randomStringFactory;
    }
}