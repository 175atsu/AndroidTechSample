package com.example.composeapp.util

import android.content.Context
import com.example.composeapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun LocalDateTime.formatYearMonthDay(
  context: Context,
  locale: Locale = Locale.getDefault(),
): String {
  return this.formatWithLocale(
    context.getString(R.string.time_format_year_month_day),
    locale,
  )
}

private fun LocalDateTime.formatWithLocale(format: String, locale: Locale): String {
  return DateTimeFormatter.ofPattern(format).withLocale(locale).format(this)
}
