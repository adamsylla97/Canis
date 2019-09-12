package com.example.canis.WorkersInformationModule.network

import retrofit2.http.GET

interface WorkersListService {

    @GET("/api/workers")
    suspend fun listOfWorkers(): List<Int>


}