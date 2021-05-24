package com.example.androidtechsample.ui.groupie

import com.example.androidtechsample.R
import com.example.androidtechsample.data.GroupiePlaygroundModel
import com.example.androidtechsample.databinding.ModelGroupieItemBinding
import com.xwray.groupie.databinding.BindableItem

class GroupieItem(
  private val playgroundModel: GroupiePlaygroundModel,
  private val listener: Listener
) : BindableItem<ModelGroupieItemBinding>() {

  interface Listener {
    fun onItemClick(id: Int)
  }

  override fun bind(viewBinding: ModelGroupieItemBinding, position: Int) {
    viewBinding.itemLabel = playgroundModel.label
    viewBinding.toGroupieView.setOnClickListener {
      listener.onItemClick(playgroundModel.clickId)
    }
  }

  override fun getLayout(): Int = R.layout.model_groupie_item
}
