package com.nbtk123.androiddi.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nbtk123.androiddi.R;
import com.nbtk123.androiddi.ads.AdFactory;
import com.nbtk123.androiddi.di.DaggerComponentsManager;
import com.nbtk123.androiddi.network.NetworkClient;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    NetworkClient networkClient;

    @Inject
    AdFactory adFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerComponentsManager.adFactoryComponent.inject(this);
        DaggerComponentsManager.networkComponent.inject(this);

        TextView tvAdContent = (TextView) findViewById(R.id.tvAdContent);
        final TextView tvHttpResponse = (TextView) findViewById(R.id.tvHttpResponse);

        networkClient.performHttpGetRequest("some url", new NetworkClient.ResponseListener() {
            @Override
            public void onResponse(String response) {
                tvHttpResponse.setText(response);
            }
        });
    }
}
