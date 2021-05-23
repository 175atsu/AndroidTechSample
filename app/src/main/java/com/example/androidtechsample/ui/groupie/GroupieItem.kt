package com.example.androidtechsample.ui.groupie

import android.view.View
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelGroupieItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class GroupieItem(
  private val itemLabel: String,
  private val listener: Listener
) : BindableItem<ModelGroupieItemBinding>() {

  interface Listener {
    fun onItemClick()
  }

  override fun bind(viewBinding: ModelGroupieItemBinding, position: Int) {
    viewBinding.itemLabel = itemLabel
    viewBinding.toGroupieView.setOnClickListener {
      listener.onItemClick()
    }
  }

  override fun getLayout(): Int = R.layout.model_groupie_item

  override fun initializeViewBinding(view: View): ModelGroupieItemBinding {
    return ModelGroupieItemBinding.bind(view)
  }

}
