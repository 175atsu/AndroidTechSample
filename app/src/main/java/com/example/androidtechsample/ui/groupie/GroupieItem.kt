package com.example.androidtechsample.ui.groupie

import com.example.androidtechsample.R
import com.example.androidtechsample.data.GroupiePlaygroundModel
import com.example.androidtechsample.databinding.ModelGroupieItemBinding
import com.xwray.groupie.databinding.BindableItem

class GroupieItem(
  private val playgroundModel: GroupiePlaygroundModel,
  private val listener: Listener
) : BindableItem<ModelGroupieItemBinding>(), EqualableContentsProvider {

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

  override fun providerEqualableContents(): Array<*> = arrayOf(playgroundModel)

  override fun equals(other: Any?): Boolean {
    return isSameContents(other)
  }

  override fun hashCode(): Int {
    return contentsHash()
  }
}
