package com.example.core.util

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigator(navId: Int) {
  findNavController().navigate(navId)
}
