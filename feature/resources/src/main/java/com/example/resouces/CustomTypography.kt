package com.example.resouces

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object CustomTypography {
  val body1 = body1(false)
  val body1Bold = body1(true)
  val body2 = body2(false)
  val body2Bold = body2(true)
  val body3 = body3(false)
  val body3Bold = body3(true)

  private fun body1(bold: Boolean) = TextStyle(
    fontSize = 16.sp,
    fontWeight = if (bold) FontWeight.Bold else null
  )

  private fun body2(bold: Boolean) = TextStyle(
    fontSize = 14.sp,
    fontWeight = if (bold) FontWeight.Bold else null
  )

  private fun body3(bold: Boolean) = TextStyle(
    fontSize = 12.sp,
    fontWeight = if (bold) FontWeight.Bold else null
  )
}
