package com.example.androidtechsample.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.EXTRA_NOTIFICATION_ID
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentNotificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : Fragment() {

  companion object {
    const val CHANNEL_ID = "channel_id"
    const val channel_name = "channel_name"
    const val channel_description = "channel_description "
  }

  private lateinit var binding: FragmentNotificationBinding

  var notificationId = 0

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentNotificationBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    createChannel()

    with(binding) {
      basicNotice.setOnClickListener {
        val builder = basicBuilder(requireContext())
        runNotice(builder)
      }
      actionNotice.setOnClickListener {
        val builder = actionBuilder(requireContext())
        runNotice(builder)
      }
    }
  }

  private fun createChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val name = channel_name
      val importance = NotificationManager.IMPORTANCE_DEFAULT
      val channel = NotificationChannel(CHANNEL_ID, name, importance)
      // チャネルを登録
      val notificationManager: NotificationManager =
        requireContext().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.createNotificationChannel(channel)
    }
  }

  private fun runNotice(builder: NotificationCompat.Builder) {
    with(NotificationManagerCompat.from(requireContext())) {
      notify(notificationId, builder.build())
      notificationId += 1
    }
  }

  private fun basicBuilder(context: Context): NotificationCompat.Builder {
    val intent = Intent(context, MainActivity::class.java).apply {
      flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    return NotificationCompat.Builder(context, CHANNEL_ID)
      .setSmallIcon(R.drawable.avatar)
      .setContentTitle(channel_name)
      .setContentText(channel_description)
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)
      .setContentIntent(pendingIntent)
      .setAutoCancel(true)
  }

  private fun actionBuilder(context: Context): NotificationCompat.Builder {
    val intent = Intent(context, NotificationBroadcastReceiver::class.java).apply {
      action = "ACTION"
    }
    val pendingIntent: PendingIntent =
      PendingIntent.getBroadcast(context, 0, intent, 0)

    return NotificationCompat.Builder(context, CHANNEL_ID)
      .setSmallIcon(R.drawable.avatar)
      .setContentTitle(channel_name)
      .setContentText(channel_description)
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)
      .addAction(
        R.drawable.ic_launcher_background, getString(R.string.notice_action),
        pendingIntent
      )
  }
}
