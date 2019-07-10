package com.example.canis.WorkersInformationModule.data

import com.example.canis.WorkersInformationModule.communication.Worker
import com.example.canis.WorkersInformationModule.communication.WorkersInformationServices

class RestWorkerProvider(private val restService: WorkersInformationServices) : WorkersDataProvider {

    override suspend fun fetchListOfWorkers(): List<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun fetchWorker(id: Int): Worker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}