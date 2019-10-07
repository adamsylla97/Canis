package com.example.canis.BeaconModule.BeaconNavigationModule;

import com.example.canis.BeaconModule.BeaconNavigationModule.network.BeaconNavigationController;
import com.example.canis.BeaconModule.BeaconNavigationModule.service.BeaconNavigationService;
import com.example.canis.RestServiceBuilder;

public class InstanceProvider {

    public static BeaconNavigationService getBuildingMapService() {
        return new BeaconNavigationService(RestServiceBuilder.INSTANCE.build(BeaconNavigationController.class));
    }
}
