package com.example.androidtechsample.ui.groupie.carousel

import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelGroupieCarouselItemBinding
import com.xwray.groupie.databinding.BindableItem

class GroupieCarouselItem(
  private val colorInt: Int,
  private val listener: Listener
) :
  BindableItem<ModelGroupieCarouselItemBinding>() {

  interface Listener {
    fun onItemClose(position: Int)
  }

  override fun getLayout(): Int = R.layout.model_groupie_carousel_item

  override fun bind(viewBinding: ModelGroupieCarouselItemBinding, position: Int) {
    with(viewBinding) {
      root.setBackgroundColor(colorInt)
      closeButton.setOnClickListener {
        listener.onItemClose(position)
      }
    }
  }
}
