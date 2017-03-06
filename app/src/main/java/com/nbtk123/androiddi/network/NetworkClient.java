package com.nbtk123.androiddi.network;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by nir on 26/02/17.
 */

public class NetworkClient {

    public interface ResponseListener {
        void onResponse(String response);
    }

    public void performHttpGetRequest(String url, final ResponseListener listener) {

        /**
         * Again, I don't want to stick to any network implementation here (Retrofit / Volley / HTTPUrlconnection)
         * for keeping this example focused on DI.
         */

        new Thread(new Runnable() {
            @Override
            public void run() {

                //We are doing a network request on another thread...
                //...
                //...
                // We return the response on the UI thread.
                Handler mainHandler = new Handler(Looper.getMainLooper());
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onResponse("HTTP 200/OK");
                    }
                });
            }
        }).start();
    }

}
