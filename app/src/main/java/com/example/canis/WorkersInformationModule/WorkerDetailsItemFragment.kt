package com.example.canis.WorkersInformationModule

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.canis.R
import com.example.canis.WorkersInformationModule.network.Worker

private const val WORKER_ID = "worker_id"

class WorkerDetailsItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("DETAILS WORKER","ON CREATE VIEW")
        return inflater.inflate(R.layout.worker_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO add getting detail data about each worker
    }

    companion object{
        @JvmStatic
        fun newInstance(id: Worker): WorkerDetailsItemFragment{
            Log.i("WORKER DETAILS INSIDE",id.name)
            return WorkerDetailsItemFragment()
        }
    }

}