package com.example.androidtechsample.ui.groupie.basic

import android.view.View
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelGroupieBasicBodyItemBinding
import com.example.androidtechsample.databinding.ModelGroupieBasicItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class HeaderItem(private val itemLabel: String) :
  BindableItem<ModelGroupieBasicItemBinding>() {
  override fun bind(viewBinding: ModelGroupieBasicItemBinding, position: Int) {
    viewBinding.itemLabel = itemLabel
  }

  override fun getLayout(): Int = R.layout.model_groupie_basic_item

  override fun initializeViewBinding(view: View): ModelGroupieBasicItemBinding {
    return ModelGroupieBasicItemBinding.bind(view)
  }
}

class BodyItem(private val itemLabel: String) : BindableItem<ModelGroupieBasicBodyItemBinding>() {
  override fun bind(viewBinding: ModelGroupieBasicBodyItemBinding, position: Int) {
    viewBinding.itemLabel = itemLabel
  }

  override fun getLayout(): Int = R.layout.model_groupie_basic_body_item

  override fun initializeViewBinding(view: View): ModelGroupieBasicBodyItemBinding {
    return ModelGroupieBasicBodyItemBinding.bind(view)
  }
}
