package com.example.groupie.carousel

import android.view.View
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelGroupieCarouselItemBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.databinding.BindableItem

class GroupieCarouselItem(
  private val colorInt: Int,
  private val adapter: GroupieAdapter
) : BindableItem<ModelGroupieCarouselItemBinding>(), OnItemClickListener {

  init {
    adapter.setOnItemClickListener(this)
  }

  override fun getLayout(): Int = R.layout.model_groupie_carousel_item

  override fun bind(viewBinding: ModelGroupieCarouselItemBinding, position: Int) {
    with(viewBinding.root) {
      setBackgroundColor(colorInt)
    }
  }

  override fun onItemClick(item: Item<*>, view: View) {
    adapter.remove(item)
  }
}
