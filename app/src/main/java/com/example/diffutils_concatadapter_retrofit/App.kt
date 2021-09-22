package com.example.diffutils_concatadapter_retrofit

import android.app.Application
import androidx.work.*
import com.example.diffutils_concatadapter_retrofit.work.PeriodicWorkManager
import dagger.hilt.android.HiltAndroidApp
import java.util.*
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startWorker()
    }

    fun startWorker() {

        val workManager = WorkManager.getInstance(applicationContext)

        val constraints = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresBatteryNotLow(true)
            .build()

        val periodicWorkRequest = PeriodicWorkRequestBuilder<PeriodicWorkManager>(
            15,
            TimeUnit.MINUTES
        ).setConstraints(constraints).build()

        workManager.enqueueUniquePeriodicWork(
            UUID.randomUUID().toString(),
            ExistingPeriodicWorkPolicy.KEEP,
            periodicWorkRequest
        )

    }
}