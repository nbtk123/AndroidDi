package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.network.NetworkClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nir on 05/03/17.
 */
@Module
public class NetworkClientModule {

    private NetworkClient networkClient;

    // When you keep a parameterless constructor around, Dagger2 is able to provide the NetworkClientModule
    // itself, so you can just write this:
    // DaggerAppcomponent.builder().build();
    // instead of this:
    // DaggerAppcomponent.builder().networkClient(new NetworkClientModule()).build();
    // this is useful when you have a lot of module and you want to fake only one.
    public NetworkClientModule() {}

    public NetworkClientModule(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    @Provides
    NetworkClient networkClient() {
        if (networkClient == null) {
            // We need to create a default one (probably original, not a fake).
            return new NetworkClient();
        }

        //Else we need to return the given NetworkClient. this is probably a fake.
        return networkClient;
    }
}
