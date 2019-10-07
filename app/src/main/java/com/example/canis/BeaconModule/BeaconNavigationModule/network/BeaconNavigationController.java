package com.example.canis.BeaconModule.BeaconNavigationModule.network;

import com.example.canis.BeaconModule.BeaconNavigationModule.model.Navigator;
import com.example.canis.BeaconModule.BeaconNavigationModule.model.Route;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BeaconNavigationController {

    @POST("/route")
    Call<Navigator> getMap(@Body Route route);
}
