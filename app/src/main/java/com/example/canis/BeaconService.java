package com.example.canis;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import com.kontakt.sdk.android.ble.configuration.ScanMode;
import com.kontakt.sdk.android.ble.configuration.ScanPeriod;
import com.kontakt.sdk.android.ble.connection.OnServiceReadyListener;
import com.kontakt.sdk.android.ble.manager.ProximityManager;
import com.kontakt.sdk.android.ble.manager.ProximityManagerFactory;
import com.kontakt.sdk.android.ble.manager.listeners.IBeaconListener;
import com.kontakt.sdk.android.ble.manager.listeners.simple.SimpleIBeaconListener;
import com.kontakt.sdk.android.common.KontaktSDK;
import com.kontakt.sdk.android.common.profile.IBeaconDevice;
import com.kontakt.sdk.android.common.profile.IBeaconRegion;

import java.util.List;

import static com.google.android.gms.common.ConnectionResult.TIMEOUT;

public class BeaconService extends Service {

    public static String nearestBeaconId;

    private static final String API_KEY = "TTMLKMtxDZnZTDymSmRdSgKOjFqBQmRB";

    private final Handler handler = new Handler();
    private ProximityManager proximityManager;
    private boolean isRunning; // Flag indicating if service is already running.

    @Override
    public void onCreate() {
        super.onCreate();
        KontaktSDK.initialize(API_KEY);
        setupProximityManager();
        isRunning = false;
    }

    private void setupProximityManager() {
        proximityManager = ProximityManagerFactory.create(this);
        proximityManager.configuration()
                .scanPeriod(ScanPeriod.RANGING)
                .scanMode(ScanMode.BALANCED);
        proximityManager.setIBeaconListener(createIBeaconListener());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (isRunning) {
            Toast.makeText(this, "Service is already running.", Toast.LENGTH_SHORT).show();
            return START_STICKY;
        }
        startScanning();
        isRunning = true;
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startScanning() {
        proximityManager.connect(new OnServiceReadyListener() {
            @Override
            public void onServiceReady() {
                proximityManager.startScanning();
                Toast.makeText(BeaconService.this, "Scanning service started.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void stopAfterDelay() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                proximityManager.disconnect();
                stopSelf();
            }
        }, TIMEOUT);
    }

    private IBeaconListener createIBeaconListener() {
        return new SimpleIBeaconListener() {
            @Override
            public void onIBeaconsUpdated(List<IBeaconDevice> iBeacons, IBeaconRegion region) {
                if (iBeacons.isEmpty()) {
                    nearestBeaconId = null;
                    return;
                }
                IBeaconDevice iBeacon = iBeacons.get(0);
                for (IBeaconDevice b : iBeacons) {
                    if (b.getDistance() < iBeacon.getDistance()) {
                        iBeacon = b;
                    }
                }
                if(!nearestBeaconId.equals(iBeacon.getUniqueId())) {
                    nearestBeaconId = iBeacon.getUniqueId();
                }
                Toast.makeText(BeaconService.this, nearestBeaconId, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        if (proximityManager != null) {
            proximityManager.disconnect();
            proximityManager = null;
        }
        Toast.makeText(BeaconService.this, "Scanning service stopped.", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
