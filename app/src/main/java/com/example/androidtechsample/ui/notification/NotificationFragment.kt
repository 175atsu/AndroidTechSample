package com.example.androidtechsample.ui.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import androidx.fragment.app.Fragment
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentNotificationBinding
import com.example.androidtechsample.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : Fragment() {

  companion object {
    const val CHANNEL_ID = "channel_id"
    const val KEY_TEXT_REPLY = "key_text_reply"
  }

  private lateinit var binding: FragmentNotificationBinding

  private var notificationId = 0

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
      directNotice.setOnClickListener {
        val builder = directBuilder(requireContext())
        runNotice(builder)
      }
      buttonNoticeProgress.setOnClickListener {
        val progressService = OneTimeWorkRequest.from(NotificationService::class.java)
        WorkManager.getInstance(requireContext()).enqueue(progressService)
      }
    }
  }

  private fun createChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val channelName = "channel_name"
      val importance = NotificationManager.IMPORTANCE_HIGH
      val channel = NotificationChannel(CHANNEL_ID, channelName, importance).apply {
        description = "ho"
        setShowBadge(true)
        enableVibration(true)
      }
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
      .setContentTitle(getString(R.string.notice_basic_label))
      .setContentText(getString(R.string.notice_basic_description))
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)
      .setContentIntent(pendingIntent)
      .setAutoCancel(true)
  }

  private fun actionBuilder(context: Context): NotificationCompat.Builder {
    val intent = Intent(context, NotificationBroadcastReceiver::class.java)
    val pendingIntent: PendingIntent =
      PendingIntent.getBroadcast(context, 1, intent, FLAG_UPDATE_CURRENT)

    return NotificationCompat.Builder(context, CHANNEL_ID)
      .setSmallIcon(R.drawable.avatar)
      .setContentTitle(getString(R.string.notice_action_label))
      .setContentText(getString(R.string.notice_action_description))
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)
      .addAction(
        R.drawable.ic_launcher_background, getString(R.string.notice_action),
        pendingIntent
      )
  }

  private fun directBuilder(context: Context): NotificationCompat.Builder {
    val replyLabel: String = resources.getString(R.string.notice_action)
    val remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
      setLabel(replyLabel)
      build()
    }

    val replyPendingIntent: PendingIntent =
      PendingIntent.getBroadcast(
        context,
        notificationId,
        Intent(context, NotificationBroadcastReceiver::class.java).apply {
          flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        },
        FLAG_UPDATE_CURRENT
      )

    val action: NotificationCompat.Action =
      NotificationCompat.Action.Builder(
        R.drawable.ic_launcher_background,
        getString(R.string.notice_direct),
        replyPendingIntent
      )
        .addRemoteInput(remoteInput)
        .build()

    return NotificationCompat.Builder(context, CHANNEL_ID)
      .setSmallIcon(R.drawable.avatar)
      .setContentTitle(getString(R.string.notice_direct_label))
      .setContentText(getString(R.string.notice_direct_description))
      .addAction(action)
  }
}
