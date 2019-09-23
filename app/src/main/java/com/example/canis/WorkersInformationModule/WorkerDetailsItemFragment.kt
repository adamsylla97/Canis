package com.example.canis.WorkersInformationModule

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.canis.R
import com.example.canis.WorkersInformationModule.model.Worker
import kotlinx.android.synthetic.main.worker_details.*
import kotlinx.android.synthetic.main.worker_details.view.*
import kotlinx.android.synthetic.main.worker_item.view.*

private const val WORKER_ID = "worker_id"

class WorkerDetailsItemFragment(private val worker: Worker) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.worker_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view).load(worker.photo).placeholder(R.drawable.photo_placeholder).into(view.workerPhoto)
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