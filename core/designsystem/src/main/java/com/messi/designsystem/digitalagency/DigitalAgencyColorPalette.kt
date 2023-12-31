package com.messi.designsystem.digitalagency

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DigitalAgencyColorPalette(
  val primary: Color,
  val body: Color,
)

val lightDigitalAgencyColorPalette = DigitalAgencyColorPalette(
  primary = DigitalAgencyPrimitiveColor.white,
  body = DigitalAgencyPrimitiveColor.Sumi900,
)
val darkDigitalAgencyColorPalette = DigitalAgencyColorPalette(
  primary = Color(0xFF1A1A1C),
  body = DigitalAgencyPrimitiveColor.white,
)
