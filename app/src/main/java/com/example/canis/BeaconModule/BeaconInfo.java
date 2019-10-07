package com.example.canis.BeaconModule;

import java.util.Observable;

public final class BeaconInfo extends Observable {

    private static BeaconInfo beaconInfo;

    public static BeaconInfo getInstance() {
        if (beaconInfo == null) {
            beaconInfo = new BeaconInfo();
        }
        return beaconInfo;
    }

    private String beaconId = "";

    void setNearestBeaconId(String beaconId) {
        this.beaconId = beaconId;
        setChanged();
        notifyObservers(beaconId);
    }

    String getNearestBeaconId() {
        return beaconId;
    }
}
