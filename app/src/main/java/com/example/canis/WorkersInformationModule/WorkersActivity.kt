package com.example.canis.WorkersInformationModule

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.canis.R

class WorkersActivity : AppCompatActivity(), WorkersFragment.OnWorkerClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workers)
        supportActionBar?.title = "Workers information"
        Log.i("ABCDE","WE ARE IN WORKERS ACTIVITY")
        if(savedInstanceState == null){
            val fragment = WorkersFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.activity_workers, fragment).commit()
        }
    }

    override fun onWorkerClicked(id: Long) {
        val fragment: Fragment = WorkerDetailsItemFragment.newInstance(id)
        supportFragmentManager
                .beginTransaction()
                .addToBackStack("worker_detail")
                .replace(R.id.workerDetails,fragment)
                .commit()
    }
}