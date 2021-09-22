package com.example.diffutils_concatadapter_retrofit.work

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class PeriodicWorkManager(val context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {

    private val notificationHandler : NotificationHandler = NotificationHandler(context)

    override fun doWork(): Result {

        notificationHandler.createNotification("Notificação",
            "Enviando notificação com WorkManager").let{ notification ->
            NotificationManagerCompat.from(context).notify((0..999).random(), notification)
        }
        return Result.success()
    }

}