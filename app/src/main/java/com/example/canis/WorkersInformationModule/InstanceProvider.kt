package com.example.canis.WorkersInformationModule

import com.example.canis.WorkersInformationModule.communication.WorkersInformationService
import com.example.canis.WorkersInformationModule.communication.WorkersListService
import com.example.canis.WorkersInformationModule.data.RestWorkerProvider
import com.example.canis.WorkersInformationModule.data.WorkersDataProvider
import com.example.canis.WorkersInformationModule.model.WorkersService
import org.koin.dsl.module

object InstanceProvider {

    val commonModule = module {

        single { RestServiceBuilder.build(WorkersInformationService::class.java) }
        single { RestServiceBuilder.build(WorkersListService::class.java)}
        single<WorkersDataProvider> {RestWorkerProvider(get(), get())}
        single { WorkersService(get())}

    }
}