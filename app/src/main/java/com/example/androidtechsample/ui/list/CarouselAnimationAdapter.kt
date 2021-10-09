package com.example.androidtechsample.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechsample.databinding.ModelUserIconBinding

class CarouselAnimationAdapter(
  private val followUserList: List<FollowUser>,
  private val listener: Listener
) : RecyclerView.Adapter<CarouselAnimationViewHolder>() {

  interface Listener {
    fun itemClick(position: Int)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselAnimationViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ModelUserIconBinding.inflate(inflater, parent, false)
    return CarouselAnimationViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CarouselAnimationViewHolder, position: Int) {
    holder.bind(followUserList[position])
    holder.itemView.setOnClickListener {
      listener.itemClick(position)
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
