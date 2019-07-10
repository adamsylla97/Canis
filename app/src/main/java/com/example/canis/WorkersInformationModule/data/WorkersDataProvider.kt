package com.example.canis.WorkersInformationModule.data

import com.example.canis.WorkersInformationModule.communication.Worker

interface WorkersDataProvider {

    suspend fun fetchListOfWorkers(): List<Int>
    suspend fun fetchWorker(id: Int): Worker

}