package com.example.composeapp.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.glance.GlanceModifier
import androidx.glance.LocalSize
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.size

@Composable
fun SquareBox(modifier: GlanceModifier = GlanceModifier, content: @Composable (Dp) -> Unit) {
  Box(modifier = GlanceModifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    val size = LocalSize.current

    val widgetSize = if (size.height > size.width) {
      size.width
    } else {
      size.height
    }
    Box(modifier = modifier.size(widgetSize)) {
      content(widgetSize)
    }
  }
}
