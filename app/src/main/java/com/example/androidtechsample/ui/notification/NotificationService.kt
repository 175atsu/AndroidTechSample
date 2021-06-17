package com.example.androidtechsample.ui.notification

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.androidtechsample.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import timber.log.Timber

class NotificationService(
  private val context: Context,
  workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

  companion object {
    const val PROGRESS_MAX = 100
    const val PROGRESS_TITLE = "タイトル"
  }

  private val notificationId = 1
  private var count = 0

  override suspend fun doWork(): Result {
    val builder = progressBuilder(context, "0", PROGRESS_MAX, count)
    runNotice(builder)
    withContext(Dispatchers.IO) {
      repeat(PROGRESS_MAX) {
        lordStart()
      }
    }
    runNotice(progressBuilder(context, "ロード完了", 0, 0))
    return Result.success()
  }

  private fun runNotice(builder: NotificationCompat.Builder) {
    with(NotificationManagerCompat.from(context)) {
      notify(notificationId, builder.build())
    }
  }

  private fun progressBuilder(
    context: Context,
    label: String,
    maxCount: Int,
    progress: Int
  ): NotificationCompat.Builder {
    return NotificationCompat.Builder(context, NotificationFragment.CHANNEL_ID)
      .setSmallIcon(R.drawable.avatar)
      .setContentTitle(PROGRESS_TITLE)
      .setContentText(label)
      .setPriority(NotificationCompat.PRIORITY_LOW)
      .setProgress(maxCount, progress, false)
  }

  private fun lordStart() {
    runBlocking {
      Thread.sleep(100)
      Timber.d(count.toString())
      count++
      runNotice(progressBuilder(context, "$count%", PROGRESS_MAX, count))
    }
  }
}
