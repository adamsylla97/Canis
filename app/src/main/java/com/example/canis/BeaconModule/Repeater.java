package com.example.canis.BeaconModule;

import java.util.ArrayList;
import java.util.List;

public class Repeater {
    private static List beacons = new ArrayList();
    private static Object room = "E110";

    public static List getBeacons() {
        return beacons;
    }

    public static String getRoom() {
        return (String) room;
    }

    public static void setRoom(Object room) {
        if(room!=null) {
            Repeater.room = room;
        }
    }
}
