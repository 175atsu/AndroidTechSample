package com.example.androidtechsample.ui.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.RemoteInput
import timber.log.Timber

class NotificationBroadcastReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
//    val targetIntent = Intent(context, MainActivity::class.java)
//    context.stopService(targetIntent)
    getMessageText(intent)
    Timber.d("受け取ったよ")
  }

  private fun getMessageText(intent: Intent): CharSequence? {
    return RemoteInput.getResultsFromIntent(intent)?.getCharSequence(NotificationFragment.KEY_TEXT_REPLY)
  }
}
