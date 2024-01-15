package com.example.riyadal_qulub.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.riyadal_qulub.MainActivity
import com.example.riyadal_qulub.R

class CounterNotificationService(private val context: Context) {

    fun showNotification(wirdName: String, wirdMessage: String) {

        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or
                    PendingIntent.FLAG_IMMUTABLE
        )

        /*
                val increment = PendingIntent.getBroadcast(
                    context,
                    2,
                    Intent(context, CounterNotificationReceiver::class.java),
                    PendingIntent.FLAG_UPDATE_CURRENT or
                            PendingIntent.FLAG_IMMUTABLE
                )
        */


        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Wird")
            .setContentText("you have  $wirdName")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(wirdMessage)
            )
            .setContentIntent(activityPendingIntent) // This line sets the PendingIntent to the notification

            .build()

        val notificationManger =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManger.notify(1, notification)

    }

    companion object {
        const val CHANNEL_ID = "counter_notification"
        const val CHANNEL_NAME = "Counter"
        const val CHANNEL_DESCRIPTION = "this is to show the wird notifications"
    }
}