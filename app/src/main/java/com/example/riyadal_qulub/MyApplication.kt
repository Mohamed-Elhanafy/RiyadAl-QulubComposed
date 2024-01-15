package com.example.riyadal_qulub

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import com.example.riyadal_qulub.notification.CounterNotificationService
import dagger.hilt.android.HiltAndroidApp
import java.util.Locale

@HiltAndroidApp
class MyApplication : Application(){

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(updateBaseContextLocale(base))
    }

    private fun updateBaseContextLocale(context: Context): Context {
        val locale = Locale("ar") // Arabic locale
        Locale.setDefault(locale)

        val res: Resources = context.resources
        val configuration: Configuration = res.configuration
        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }

    override fun onCreate() {
        super.onCreate()

        // Create notification channel
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                CounterNotificationService.CHANNEL_ID,
                CounterNotificationService.CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = CounterNotificationService.CHANNEL_DESCRIPTION
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}