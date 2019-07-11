package com.example.canis.WorkersInformationModule.data

import com.example.canis.WorkersInformationModule.communication.Worker
import com.example.canis.WorkersInformationModule.communication.WorkersInformationService
import com.example.canis.WorkersInformationModule.communication.WorkersListService

class RestWorkerProvider(private val workerListRestService: WorkersListService,
                         private val specificWorkerRestService: WorkersInformationService) : WorkersDataProvider {

    override suspend fun fetchListOfWorkers(): List<Int> {
        return workerListRestService.listOfWorkers()
    }

    override suspend fun fetchWorker(id: Int): Worker {
        return specificWorkerRestService.workerInformation(id)
    }

}