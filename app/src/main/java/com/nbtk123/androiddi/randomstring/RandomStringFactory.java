package com.nbtk123.androiddi.randomstring;

import java.lang.String;
import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by nir on 26/02/17.
 */

public class RandomStringFactory {
    public String createString() {
        return UUID.randomUUID().toString();
    }
}
