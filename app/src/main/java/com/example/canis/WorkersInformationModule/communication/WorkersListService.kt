package com.example.canis.WorkersInformationModule.communication

import retrofit2.http.GET

interface WorkersListService {

    @GET("/api/workers")
    suspend fun listOfWorkers(): List<Int>


}