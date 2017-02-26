package com.nbtk123.androiddi.di;

/**
 * Created by nir on 26/02/17.
 */

public class DaggerComponentsManager {

    // All the public static fields are initialized with the ORIGINAL modules.

    public static NetworkComponent networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule()).build();
    public static AdFactoryComponent adFactoryComponent = DaggerAdFactoryComponent.builder().adFactoryModule(new AdFactoryModule()).build();
}
