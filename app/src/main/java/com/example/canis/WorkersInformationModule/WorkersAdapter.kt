package com.example.canis.WorkersInformationModule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.canis.R
import com.example.canis.WorkersInformationModule.communication.Worker
import kotlinx.android.synthetic.main.worker_item.view.*

class WorkersAdapter(val workersList: List<Worker>, private val listener: (Long) -> Unit): RecyclerView.Adapter<WorkersAdapter.WorkersHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkersAdapter.WorkersHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.worker_item, parent, false)
        return WorkersHolder(inflatedView, listener)
    }

    override fun getItemCount(): Int {
        return workersList.size
    }

    override fun onBindViewHolder(holder: WorkersAdapter.WorkersHolder, position: Int) {
        val item = workersList[position]
        holder.bind(item)
    }

    class WorkersHolder(private val view: View, private val itemClick: (Long)->Unit):RecyclerView.ViewHolder(view){

        fun bind(worker: Worker){
            view.workerName.text = worker.name //TODO add worker for buissness part for process first and last name + inz / mgr / d / prof etc.
            Glide.with(view).load(worker.photo).into(view.workerImage)
        }

    }

}