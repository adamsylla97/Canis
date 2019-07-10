package com.example.canis.WorkersInformationModule.model

import com.example.canis.WorkersInformationModule.communication.Worker
import com.example.canis.WorkersInformationModule.data.WorkersDataProvider

class WorkersService(private val dataProvider: WorkersDataProvider) {

    private val workersList = mutableListOf<Worker>()

    suspend fun fetchWorkers(): List<Worker> {

        val listOfWorkers = dataProvider.fetchListOfWorkers()

        listOfWorkers.forEach{
            val worker = dataProvider.fetchWorker(it)
            workersList.add(worker)
        }

        return workersList

    }

}