package com.example.groupie.basic

import com.example.groupie.R
import com.example.groupie.databinding.ModelGroupieBasicBodyItemBinding
import com.example.groupie.databinding.ModelGroupieBasicItemBinding
import com.xwray.groupie.databinding.BindableItem

class HeaderItem(private val itemLabel: String) :
  BindableItem<ModelGroupieBasicItemBinding>() {
  override fun bind(viewBinding: ModelGroupieBasicItemBinding, position: Int) {
    viewBinding.itemLabel = itemLabel
  }

  override fun getLayout(): Int = R.layout.model_groupie_basic_item
}

class BodyItem(private val itemLabel: String) : BindableItem<ModelGroupieBasicBodyItemBinding>() {
  override fun bind(viewBinding: ModelGroupieBasicBodyItemBinding, position: Int) {
    viewBinding.itemLabel = itemLabel
  }

  override fun getLayout(): Int = R.layout.model_groupie_basic_body_item
}
