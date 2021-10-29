package com.example.groupie

import com.example.groupie.data.GroupiePlaygroundModel
import com.example.groupie.databinding.ModelGroupieItemBinding
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
