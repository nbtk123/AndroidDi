package com.nbtk123.androiddi.di;

import com.nbtk123.androiddi.network.NetworkClient;
import com.nbtk123.androiddi.ui.MainActivity;

import dagger.Component;

/**
 * Created by nir on 26/02/17.
 */

@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    void inject (MainActivity activity);

    NetworkClient provideNetworkClient();
}
