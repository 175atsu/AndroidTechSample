package com.example.androidtechsample.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentSpanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpanFragment : Fragment() {

  private lateinit var binding: FragmentSpanBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentSpanBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      textColor.text = spanColor()
      textMultiple.text = spanMultiple()
      textUnderline.text = spanUnderline()
      textSize.text = spanSize()
      textBackground.text = spanBackgroundColor()
      textParagraph.text = spanParagraph()
    }
  }

  private fun spanColor(): SpannableStringBuilder {
    return SpannableStringBuilder(getString(R.string.span_sample_text)).apply {
      setSpan(
        ForegroundColorSpan(Color.RED),
        7, // start
        this.length, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanMultiple(): SpannableString {
    return SpannableString(getString(R.string.span_sample_text)).apply {
      setSpan(
        ForegroundColorSpan(Color.RED),
        7, // start
        9, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
      setSpan(
        StyleSpan(Typeface.BOLD),
        7,
        this.length,
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanUnderline(): SpannableStringBuilder {
    return SpannableStringBuilder(getString(R.string.span_sample_text)).apply {
      setSpan(
        UnderlineSpan(),
        7, // start
        this.length, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanSize(): SpannableStringBuilder {
    return SpannableStringBuilder(getString(R.string.span_sample_text)).apply {
      setSpan(
        RelativeSizeSpan(1.5f),
        7, // start
        this.length, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanBackgroundColor(): SpannableStringBuilder {
    return SpannableStringBuilder(getString(R.string.span_sample_text)).apply {
      setSpan(
        BackgroundColorSpan(Color.RED),
        7, // start
        this.length, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanParagraph(): SpannableStringBuilder {
    return SpannableStringBuilder(getString(R.string.span_sample_text_paragraph)).apply {
      setSpan(
        QuoteSpan(),
        0, // start
        this.length, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }
}
