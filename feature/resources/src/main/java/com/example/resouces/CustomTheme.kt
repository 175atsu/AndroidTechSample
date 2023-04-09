package com.example.resouces

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

@Composable
fun CustomTheme(
  colors: ColorPalette = lightColorPalette(),
  content: @Composable () -> Unit
) {
  MaterialTheme {
    CompositionLocalProvider(
      LocalColorPalette provides colors,
      content = content
    )
  }
}

private val LocalColorPalette = compositionLocalOf<ColorPalette> {
  error("No spindle color palette is provided!")
}

object CustomTheme {
  val colors: ColorPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalColorPalette.current
}
