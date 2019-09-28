package com.example.canis.BeaconNavigationModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.canis.BeaconService;
import com.example.canis.R;

public class BeaconNavigationActivity extends AppCompatActivity {

    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon_navigation);
        serviceIntent = new Intent(getApplicationContext(), BeaconService.class);
        startService(serviceIntent);
    }
}
