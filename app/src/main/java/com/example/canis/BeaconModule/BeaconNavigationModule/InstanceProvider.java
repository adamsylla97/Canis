package com.example.canis.BeaconModule.BeaconNavigationModule;

import com.example.canis.BeaconModule.BeaconNavigationModule.network.BeaconNavigationController;
import com.example.canis.BeaconModule.BeaconNavigationModule.service.BeaconNavigationService;
import com.example.canis.RestServiceBuilder;
import com.example.canis.RestServiceBuilder2;

public class InstanceProvider {

    public static BeaconNavigationService getBuildingMapService() {
        return new BeaconNavigationService(RestServiceBuilder2.INSTANCE.build(BeaconNavigationController.class));
    }
}
