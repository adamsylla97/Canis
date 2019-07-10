package com.example.canis.WorkersInformationModule

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestServiceBuilder{

    private val url = "" //TODO ADD BASIC URL

    private val httpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

    //prepare for later usage of koin
    fun <T> build(service: Class<T>): T {
        return retrofit.create(service)
    }

}