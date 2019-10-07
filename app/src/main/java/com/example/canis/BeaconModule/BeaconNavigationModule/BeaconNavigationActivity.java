package com.example.canis.BeaconModule.BeaconNavigationModule;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.canis.BeaconModule.BeaconInfo;
import com.example.canis.BeaconModule.BeaconNavigationModule.model.Navigator;
import com.example.canis.BeaconModule.BeaconNavigationModule.service.BeaconNavigationService;
import com.example.canis.R;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.Observable;
import java.util.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeaconNavigationActivity extends AppCompatActivity implements Observer {

    private BeaconNavigationService beaconNavigationService;

    private ImageView imageView;

    private BeaconInfo beaconInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon_navigation);
        imageView = (ImageView) findViewById(R.id.buildingMap);
        beaconNavigationService = InstanceProvider.getBuildingMapService();
        beaconInfo = BeaconInfo.getInstance();
        beaconInfo.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        beaconNavigationService.findRoute((String) o, "E110").enqueue(new Callback<Navigator>() {
            @Override
            public void onResponse(Call<Navigator> call, Response<Navigator> response) {
                GlideToVectorYou
                        .init()
                        .with(getApplicationContext())
                        .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                        .load(Uri.parse(response.body().getMapUrl()), imageView);
            }

            @Override
            public void onFailure(Call<Navigator> call, Throwable t) {
            }
        });
    }
}
