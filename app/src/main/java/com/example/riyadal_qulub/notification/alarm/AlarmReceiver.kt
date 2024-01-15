package com.example.riyadal_qulub.notification.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.riyadal_qulub.notification.CounterNotificationService

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val message = intent?.getStringExtra("EXTRA_MESSAGE") ?: return

        println(message)
        Log.i("TAG", "onReceive:  $message")
        val service = CounterNotificationService(context!!)
        service.showNotification("name" , message)
    }

}
