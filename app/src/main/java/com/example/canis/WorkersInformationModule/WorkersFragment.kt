package com.example.canis.WorkersInformationModule

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canis.R
import com.example.canis.WorkersInformationModule.network.Worker
import kotlinx.android.synthetic.main.worker_module_layout.*
import java.lang.RuntimeException

class WorkersFragment : Fragment() {

    //private val onWorkerClickedListener: (Long) -> Unit = {id -> listener?.onWorkerClicked(id)}
    //private var listener: OnWorkerClickedListener? = null
    private val workersList: List<Worker>? = listOf(Worker("a","b","c","d","e","d","3"),Worker("1","2","3","4",
            "5","6","7"))

    val adapter = WorkersAdapter{onItemClicked(it)}

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.worker_module_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        workersRecycleView.layoutManager = LinearLayoutManager(context)
        adapter.addList(workersList!!)
        workersRecycleView.adapter = adapter

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
//        if(context is OnWorkerClickedListener){
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnCourseClickedListener")
//        }
    }

    private fun onItemClicked(worker: Worker){
        val workerDetailsItemFragment = WorkerDetailsItemFragment.newInstance(worker)
        fragmentManager?.let{
            it.beginTransaction()
                    .addToBackStack("worker_item")
                    .replace(R.id.workersModule,workerDetailsItemFragment)
                    .commit()
        }
    }

    override fun onDetach() {
        super.onDetach()
       // listener = null
    }

//    interface OnWorkerClickedListener{
//        fun onWorkerClicked(id: Long)
//    }

    companion object{
        @JvmStatic
        fun newInstance() = WorkersFragment()
    }

}