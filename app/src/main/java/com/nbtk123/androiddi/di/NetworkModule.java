package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.network.NetworkClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nir on 26/02/17.
 */

@Module
public class NetworkModule {

    @Provides
    public NetworkClient provideNetworkClient() {
        return new NetworkClient();
    }
}
