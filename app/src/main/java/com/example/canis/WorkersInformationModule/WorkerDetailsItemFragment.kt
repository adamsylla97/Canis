package com.example.canis.WorkersInformationModule

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.canis.R
import com.example.canis.WorkersInformationModule.model.Worker
import kotlinx.android.synthetic.main.worker_details.*


class WorkerDetailsItemFragment(private val worker: Worker) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.worker_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstName.text = worker.firstName
        lastName.text = worker.lastName
        contact.text = worker.contact
        address.text = worker.address
        hours.text = worker.hours


    }

    companion object{
        @JvmStatic
        fun newInstance(worker: Worker): WorkerDetailsItemFragment{
            return WorkerDetailsItemFragment(worker)
        }
    }

}