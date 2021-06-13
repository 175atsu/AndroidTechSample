package com.example.androidtechsample.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationBroadcastReceiver: BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
    val targetIntent = Intent(context, MainActivity::class.java)
    context.stopService(targetIntent)
  }
}
