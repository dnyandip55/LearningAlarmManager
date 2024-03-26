package com.example.alarmmanagerapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var  alarm:AlarmManager
    lateinit var pi:PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alarm=getSystemService(ALARM_SERVICE) as AlarmManager
        pi=PendingIntent.getBroadcast(this,12,Intent(this,RailwayReceiver::class.java),PendingIntent.FLAG_IMMUTABLE)

    }

    fun startRemainder(view: View) {

        //set the alarm type
        val alarmType=AlarmManager.ELAPSED_REALTIME

        //define when do you want to get your first alarm
        val firstTriggerTime=SystemClock.elapsedRealtime()

        //what is the interval time
        val intervalTime:Long=2*60*1000

        //set the alarm








































































































        alarm.setInexactRepeating(alarmType,firstTriggerTime,intervalTime,pi)

    }
    fun stopRemainder(view: View) {

        alarm.cancel(pi)
    }
}