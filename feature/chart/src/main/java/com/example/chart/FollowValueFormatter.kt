package com.example.chart

import com.github.mikephil.charting.formatter.ValueFormatter

class FollowValueFormatter : ValueFormatter() {
  override fun getFormattedValue(value: Float): String {
    return (value.toInt() / 1000.0).toString() + "千"
  }
}
