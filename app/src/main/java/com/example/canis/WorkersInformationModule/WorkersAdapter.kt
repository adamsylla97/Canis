package com.example.canis.WorkersInformationModule

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.canis.R
import com.example.canis.WorkersInformationModule.network.Worker
import kotlinx.android.synthetic.main.worker_item.view.*

class WorkersAdapter(private val listener: (Worker) -> Unit): RecyclerView.Adapter<WorkersAdapter.WorkersHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkersHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.worker_item, parent, false)
        return WorkersHolder(inflatedView, listener)
    }

    val workersList = mutableListOf<Worker>()

    fun addList(listToAdd: List<Worker>){
        workersList.addAll(listToAdd)
    }

    override fun getItemCount(): Int {
        return workersList.size
    }

    override fun onBindViewHolder(holder: WorkersHolder, position: Int) {
        val item = workersList[position]
        holder.bind(item)
    }

    class WorkersHolder(private val view: View, private val itemClick: (Worker) -> Unit):RecyclerView.ViewHolder(view){
        fun bind(worker: Worker){
            view.workerName.text = worker.name
            Glide.with(view).load(R.drawable.ic_person_black_24dp).into(view.workerImage)
            view.setOnClickListener {
                itemClick(worker)
            }
        }

    }

}