package com.example.canis.WorkersInformationModule.network

import retrofit2.http.GET
import retrofit2.http.Path

interface WorkersInformationService {

    @GET("/api/workers/{id}")
    suspend fun workerInformation(@Path("id") id:Int) : Worker

}