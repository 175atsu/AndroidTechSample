package com.example.resouces

import androidx.compose.ui.graphics.Color

interface ColorPalette {
  val surfacePrimary: Color

  // text color
  val textHighEmphasis: Color
  val textHighEmphasisInverse: Color

  // object color
  val objectHighEmphasis: Color
}

fun lightColorPalette(): ColorPalette = object : ColorPalette {
  override val surfacePrimary: Color = PrimitiveColor.white100
  override val textHighEmphasis: Color = PrimitiveColor.black100
  override val textHighEmphasisInverse: Color = PrimitiveColor.white100
  override val objectHighEmphasis: Color = PrimitiveColor.black100
}

fun darkColorPalette(): ColorPalette = object : ColorPalette {
  override val surfacePrimary: Color = PrimitiveColor.black100
  override val textHighEmphasis: Color = PrimitiveColor.white100
  override val textHighEmphasisInverse: Color = PrimitiveColor.black100
  override val objectHighEmphasis: Color = PrimitiveColor.white100
}
