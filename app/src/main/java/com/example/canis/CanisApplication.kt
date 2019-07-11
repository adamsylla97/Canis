package com.example.canis

import android.app.Application
import com.example.canis.WorkersInformationModule.InstanceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CanisApplication : Application() {

    override fun onCreate(){

        super.onCreate()

        startKoin {
            // Android context
            androidContext(this@CanisApplication)
            // modules
            modules(InstanceProvider.commonModule)
        }

    }

}