package com.example.androidtechsample.ui.groupie.swipe

import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelGroupieSwipeItemBinding
import com.xwray.groupie.databinding.BindableItem

class GroupieSwipeItem(
  private val colorInt: Int
) : BindableItem<ModelGroupieSwipeItemBinding>() {
  override fun bind(viewBinding: ModelGroupieSwipeItemBinding, position: Int) {
    with(viewBinding) {
      item.setBackgroundColor(colorInt)
    }
  }

  override fun getLayout(): Int = R.layout.model_groupie_swipe_item
}
