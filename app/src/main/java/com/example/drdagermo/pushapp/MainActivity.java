package com.example.drdagermo.pushapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.worklight.wlclient.api.WLAccessTokenListener;
import com.worklight.wlclient.api.WLAuthorizationManager;
import com.worklight.wlclient.api.WLClient;
import com.worklight.common.WLAnalytics;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import com.worklight.wlclient.auth.AccessToken;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WLClient.createInstance(this).connect(new WLResponseListener() {
            @Override
            public void onSuccess(WLResponse wlResponse) {
                Log.i( "MFP", "Success" );
            }

            @Override
            public void onFailure(WLFailResponse wlFailResponse) {
                Log.i( "MFP", "NoConn" );
            }
        });

        WLAnalytics.init(this.getApplication());
        WLAnalytics.addDeviceEventListener(WLAnalytics.DeviceEvent.LIFECYCLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WLAnalytics.send();
    }
}
