package com.example.groupie.swipe

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.groupie.R
import com.example.groupie.databinding.ModelGroupieSwipeItemBinding
import com.xwray.groupie.databinding.BindableItem

class GroupieSwipeItem(
  private val colorInt: Int
) : BindableItem<ModelGroupieSwipeItemBinding>() {
  override fun bind(viewBinding: ModelGroupieSwipeItemBinding, position: Int) {
    with(viewBinding) {
      item.setBackgroundColor(colorInt)
      indexId = position.toString()
    }
  }

  override fun getLayout(): Int = R.layout.model_groupie_swipe_item

  override fun getSwipeDirs(): Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT

  override fun getDragDirs(): Int = ItemTouchHelper.UP or ItemTouchHelper.DOWN
}
