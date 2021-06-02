package com.example.androidtechsample.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentSpanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpanFragment : Fragment() {

  private lateinit var binding: FragmentSpanBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentSpanBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val spannable = SpannableStringBuilder("Text is spantastic!")
    spannable.setSpan(
      ForegroundColorSpan(Color.RED),
      8, // start
      12, // end
      Spannable.SPAN_EXCLUSIVE_INCLUSIVE
    )
    with(binding) {
      text1.text = spannable
    }
  }
}
