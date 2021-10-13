package com.example.androidtechsample.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.ModelUserIconBinding

class CarouselAnimationAdapter(
  private val followUserList: List<FollowUser>,
  private val listener: Listener
) : RecyclerView.Adapter<CarouselAnimationViewHolder>() {

  companion object {
    const val NO_SELECT = -1
  }

  var selectPosition = NO_SELECT

  interface Listener {
    fun itemClick(position: Int, centerPosition: Int)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselAnimationViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ModelUserIconBinding.inflate(inflater, parent, false)
    return CarouselAnimationViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CarouselAnimationViewHolder, position: Int) {
    holder.bind(followUserList[position])
    if (selectPosition == position) {
      holder.itemView.setBackgroundResource(R.color.cyan_200)
    } else {
      holder.itemView.setBackgroundResource(0)
    }
    holder.itemView.setOnClickListener {
      selectPosition = if (selectPosition != position) {
        notifyItemChanged(selectPosition)
        notifyItemChanged(position)
        position
      } else {
        notifyItemChanged(position)
        NO_SELECT
      }
      val itemPosition = (it.x + it.width / 2).toInt()
      listener.itemClick(selectPosition, itemPosition)
    }
  }

  override fun getItemCount(): Int = followUserList.size
}

class CarouselAnimationViewHolder(private val binding: ModelUserIconBinding) :
  RecyclerView.ViewHolder(binding.root) {
  fun bind(item: FollowUser) {
    binding.textUserName.text = item.name
    binding.image = item.icon
  }
}
