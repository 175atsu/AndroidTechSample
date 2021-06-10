package com.example.androidtechsample.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.QuoteSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.fragment.app.Fragment
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentSpanBinding
import com.example.androidtechsample.util.rangeOfIndex
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
      textClick.apply {
        text = spanClick()
        movementMethod = LinkMovementMethod.getInstance()
      }
      textKtx.text = spanColorKtx()
    }
  }

  private fun spanColor(): SpannableStringBuilder {
    val sampleLabel = getString(R.string.span_sample_text)
    val colorRange = sampleLabel.rangeOfIndex("Text")
    return SpannableStringBuilder(sampleLabel).apply {
      setSpan(
        ForegroundColorSpan(Color.RED),
        colorRange.first, // start
        colorRange.last.inc(), // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanColorKtx(): SpannedString {
    val sampleLabel = getString(R.string.span_sample_text)
    val colorRange = sampleLabel.rangeOfIndex("Text")
    return buildSpannedString {
      append(sampleLabel.subSequence(0, colorRange.first))
      color(Color.RED) {
        append(sampleLabel.subSequence(colorRange))
      }
    }
  }

  private fun spanMultiple(): SpannableString {
    val sampleLabel = getString(R.string.span_sample_text)
    val boldRange = sampleLabel.rangeOfIndex("Text")
    val colorRange = sampleLabel.rangeOfIndex("Te")
    return SpannableString(sampleLabel).apply {
      setSpan(
        ForegroundColorSpan(Color.RED),
        colorRange.first, // start
        colorRange.last.inc(), // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
      setSpan(
        StyleSpan(Typeface.BOLD),
        boldRange.first,
        boldRange.last.inc(),
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanUnderline(): SpannableStringBuilder {
    val sampleLabel = getString(R.string.span_sample_text)
    val underlineRange = sampleLabel.rangeOfIndex("Text")
    return SpannableStringBuilder(sampleLabel).apply {
      setSpan(
        UnderlineSpan(),
        underlineRange.first, // start
        underlineRange.last.inc(), // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanSize(): SpannableStringBuilder {
    val sampleLabel = getString(R.string.span_sample_text)
    val sizeRange = sampleLabel.rangeOfIndex("Text")
    return SpannableStringBuilder(sampleLabel).apply {
      setSpan(
        RelativeSizeSpan(1.5f),
        sizeRange.first, // start
        sizeRange.last.inc(), // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanBackgroundColor(): SpannableStringBuilder {
    val sampleLabel = getString(R.string.span_sample_text)
    val sizeRange = sampleLabel.rangeOfIndex("Text")
    return SpannableStringBuilder(sampleLabel).apply {
      setSpan(
        BackgroundColorSpan(Color.RED),
        sizeRange.first, // start
        sizeRange.last.inc(), // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanParagraph(): SpannableStringBuilder {
    val sampleLabel = getString(R.string.span_sample_text_paragraph)
    return SpannableStringBuilder(sampleLabel).apply {
      setSpan(
        QuoteSpan(),
        0, // start
        this.length, // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }

  private fun spanClick(): SpannableStringBuilder {
    val sampleLabel = getString(R.string.span_sample_text)
    val sizeRange = sampleLabel.rangeOfIndex("Text")
    return SpannableStringBuilder(sampleLabel).apply {
      setSpan(
        object : ClickableSpan() {
          override fun onClick(widget: View) {
            // TODO クリック処理
          }
        },
        sizeRange.first, // start
        sizeRange.last.inc(), // end
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
      )
    }
  }
}
