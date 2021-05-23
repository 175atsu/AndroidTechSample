package com.example.androidtechsample.ui.groupie

import android.view.View
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelGroupieBasicItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class GroupieBasicItem(private val itemLabel: String) : BindableItem<ModelGroupieBasicItemBinding>() {
  override fun bind(viewBinding: ModelGroupieBasicItemBinding, position: Int) {
    viewBinding.itemLabel = itemLabel
  }

  override fun getLayout(): Int = R.layout.model_groupie_basic_item

  override fun initializeViewBinding(view: View): ModelGroupieBasicItemBinding {
    return ModelGroupieBasicItemBinding.bind(view)
  }
}
