package com.example.canis.WorkersInformationModule

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.canis.R

class WorkersActivity : AppCompatActivity(), WorkersFragment.OnWorkerClickedListener {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        supportActionBar?.title = "Workers information"
        if(savedInstanceState == null){
            val fragment = WorkersFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.workersRecycleView, fragment).commit()
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