package com.example.canis.WorkersInformationModule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.canis.R

private const val WORKER_ID = "worker_id"

class WorkerDetailsItemFragment : Fragment() {

    private val workerId: Long by lazy { arguments?.let { it.getLong(WORKER_ID, 1L) } ?: 0 }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.worker_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO add getting detail data about each worker
    }

    companion object{
        @JvmStatic
        fun newInstance(id:Long)=
            WorkerDetailsItemFragment().apply {
                arguments = Bundle().apply {
                    putLong(WORKER_ID,id)
                }
            }

    }

}