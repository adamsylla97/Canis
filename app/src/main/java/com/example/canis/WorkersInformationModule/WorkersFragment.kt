package com.example.canis.WorkersInformationModule

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.canis.R
import com.example.canis.WorkersInformationModule.communication.Worker
import java.lang.RuntimeException

class WorkersFragment : Fragment() {

    private val onWorkerClickedListener: (Long) -> Unit = {id -> listener?.onWorkerClicked(id)}
    private var listener: OnWorkerClickedListener? = null
    private val workersList: List<Worker>? = listOf(Worker("a","b","c","d","e","d"))

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("ABCDE","WE ARE IN WORKERS FRAGMENT")
        return inflater.inflate(R.layout.worker_module_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.workersRecycleView)
        val adapter = WorkersAdapter(workersList!!,onWorkerClickedListener)
        recyclerView.adapter = adapter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnWorkerClickedListener){
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnCourseClickedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnWorkerClickedListener{
        fun onWorkerClicked(id: Long)
    }

    companion object{
        @JvmStatic
        fun newInstance() = WorkersFragment()
    }

}