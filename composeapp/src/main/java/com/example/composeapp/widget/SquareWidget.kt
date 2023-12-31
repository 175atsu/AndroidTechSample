package com.example.composeapp.widget

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.ContentScale
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.composeapp.R
import com.example.composeapp.util.getRandomImage
import kotlinx.coroutines.launch

class SquareWidget : GlanceAppWidget() {

  override val sizeMode: SizeMode = SizeMode.Exact

  override suspend fun provideGlance(context: Context, id: GlanceId) = provideContent {
    val url = getImageUrl()
    val scope = rememberCoroutineScope()
    var randomImage by remember(url) { mutableStateOf<Bitmap?>(null) }

    // Load a random image
    LaunchedEffect(url) {
      randomImage = context.getRandomImage(url)
    }

    GlanceTheme {
      SquareBox {
        randomImage?.let {
          Image(
            provider = ImageProvider(it),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = GlanceModifier
              .fillMaxSize()
              .cornerRadius(16.dp)
              .clickable {
                scope.launch {
                  randomImage = context.getRandomImage(url, force = true)
                }
              }
          )
          Box(
            modifier = GlanceModifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
          ) {
            Column(
              modifier = GlanceModifier
                .fillMaxSize()
                .background(ImageProvider(R.drawable.bg_bottom_raound16))
                .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
              Text(
                text = "Android",
                style = TextStyle(color = ColorProvider(color = Color.White), fontSize = 14.sp),
                maxLines = 1
              )
              Text(
                text = "2023.4.12 13:00",
                style = TextStyle(color = ColorProvider(color = Color.White), fontSize = 10.sp),
                maxLines = 1
              )
              Text(
                text = "Android-Kotlin",
                style = TextStyle(color = ColorProvider(color = Color.White), fontSize = 14.sp),
                maxLines = 2
              )
            }
          }
        }
      }
    }
  }

  private fun getImageUrl() =
    "https://1.bp.blogspot.com/-vwSS5WNCbmg/YNNZgZ11bdI/AAAAAAAAAxg/ybCp8t6qBRYrSpVuZCffo2eDW-kGwdT1wCLcBGAsYHQ/s1024/Android_NewForDevelopers_1024x512_updated.png"
}

class SquareWidgetReceiver : GlanceAppWidgetReceiver() {
  override val glanceAppWidget = SquareWidget()
}
