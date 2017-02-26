package com.nbtk123.androiddi.ads;

import javax.inject.Inject;

/**
 * Created by nir on 26/02/17.
 */

public class AdFactory {

    @Inject
    public AdFactory() {

    }

    public Ad createAd() {
        return new Ad();
    }
}
