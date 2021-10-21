package com.example.androidtechsample.util

import android.content.Context
import android.widget.Toast

fun shortToast(context: Context, stringRes: Int) {
  Toast.makeText(
    context,
    stringRes,
    Toast.LENGTH_SHORT
  ).show()
}
