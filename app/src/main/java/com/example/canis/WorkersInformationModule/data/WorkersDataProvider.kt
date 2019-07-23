package com.example.canis.WorkersInformationModule.data

import com.example.canis.WorkersInformationModule.network.Worker

interface WorkersDataProvider {

    suspend fun fetchListOfWorkers(): List<Int>
    suspend fun fetchWorker(id: Int): Worker

}