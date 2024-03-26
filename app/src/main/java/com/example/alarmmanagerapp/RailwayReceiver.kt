package com.example.alarmmanagerapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class RailwayReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channel = NotificationChannel(
                "dnyandip",
                "Train Remainder",
                NotificationManager.IMPORTANCE_HIGH
            )

            manager.createNotificationChannel(channel)
        }

        val notification:Notification=NotificationCompat.Builder(context,"dnyandip")
            .setSmallIcon(R.drawable.railway)
            .setContentTitle("Train Timing")
            .setContentText("Train is ready to go")
            .setAutoCancel(true)
            .build()

        manager.notify(2,notification)
    }
}