package com.nbtk123.androiddi.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nbtk123.androiddi.App;
import com.nbtk123.androiddi.R;
import com.nbtk123.androiddi.network.NetworkClient;
import com.nbtk123.androiddi.randomstring.RandomStringFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    RandomStringFactory randomStringFactory;

    @Inject
    NetworkClient networkClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.appComponent.inject(this);

        final TextView tvRandomString = (TextView) findViewById(R.id.tvRandomString);
        final TextView tvHttpResponse = (TextView) findViewById(R.id.tvHttpResponse);

        tvRandomString.setText(randomStringFactory.createString());

        // This example is not about Andorid Best Practices.
        // want to keep it minimal for DI.
        // So ignore the context leak etc.
        // The DI concept is the same for Retrofit / Volley / Whatever
        networkClient.performHttpGetRequest("some url", new NetworkClient.ResponseListener() {
            @Override
            public void onResponse(String response) {
                tvHttpResponse.setText(response);
            }
        });
    }
}
