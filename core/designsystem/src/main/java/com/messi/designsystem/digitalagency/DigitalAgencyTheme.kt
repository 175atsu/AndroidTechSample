package com.messi.designsystem.digitalagency

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

@Composable
fun DigitalAgencyTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme = if (darkTheme) darkDigitalAgencyColorPalette else lightDigitalAgencyColorPalette
  CompositionLocalProvider(
    LocalDigitalAgencyColorPalette provides colorScheme,
    content = content
  )
}

private val LocalDigitalAgencyColorPalette = compositionLocalOf<DigitalAgencyColorPalette> {
  error("No DigitalAgencyColorPalette provided")
}

object DigitalAgencyTheme {
  val colors: DigitalAgencyColorPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalDigitalAgencyColorPalette.current
}
