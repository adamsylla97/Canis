package com.example.canis.WorkersInformationModule

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.canis.WorkersInformationModule.communication.Worker

class WorkersAdapter(private val listener: (Long) -> Unit): RecyclerView.Adapter<WorkersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkersAdapter.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: WorkersAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(private val view: View, private val itemClick: (Long)->Unit):RecyclerView.ViewHolder(view){
        fun bind(worker: Worker){
            //TODO implement bind method for working that binds every card to another fragment
        }
    }

}