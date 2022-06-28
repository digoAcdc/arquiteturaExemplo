package com.example.arquiteturaexemplo

import android.app.Application
import com.example.arquiteturaexemplo.di.appModule
import com.example.arquiteturaexemplo.di.repositoryModule
import com.example.arquiteturaexemplo.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, useCaseModule, repositoryModule)
        }
    }
}


