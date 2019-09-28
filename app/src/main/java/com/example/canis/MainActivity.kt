package com.example.canis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.canis.BeaconNavigationModule.BeaconNavigationActivity
import com.example.canis.NavigationModule.MapboxActivity
import com.example.canis.Places.Information.PlacesActivity
import com.example.canis.WorkersInformationModule.WorkersActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workersButton.setOnClickListener {
            startActivity(Intent(this, WorkersActivity::class.java))
        }

        navigationButton.setOnClickListener{
            //startActivity(Intent(this, MapboxActivity::class.java))
            startActivity(Intent(this, PlacesActivity::class.java))
        }

        beaconNavigationButton.setOnClickListener{
            startActivity(Intent(this, BeaconNavigationActivity::class.java))
        }

    }

}