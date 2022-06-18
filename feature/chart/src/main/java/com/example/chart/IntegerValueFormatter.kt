package com.example.chart

import com.github.mikephil.charting.formatter.ValueFormatter

class IntegerValueFormatter : ValueFormatter() {
  override fun getFormattedValue(value: Float): String {
    return value.toInt().toString() + "月"
  }
}
