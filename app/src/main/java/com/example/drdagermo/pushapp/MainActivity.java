package com.example.drdagermo.pushapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.worklight.wlclient.api.WLClient;
import com.worklight.common.WLAnalytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WLClient.createInstance(this);

        WLAnalytics.init(this.getApplication());
        WLAnalytics.addDeviceEventListener(WLAnalytics.DeviceEvent.LIFECYCLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WLAnalytics.send();
    }
}
