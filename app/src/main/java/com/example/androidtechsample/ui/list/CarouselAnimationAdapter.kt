package com.example.androidtechsample.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechsample.databinding.ModelUserIconBinding

class CarouselAnimationAdapter(
  private val followUser: List<FollowUser>
) : RecyclerView.Adapter<CarouselAnimationViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselAnimationViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ModelUserIconBinding.inflate(inflater, parent, false)
    return CarouselAnimationViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CarouselAnimationViewHolder, position: Int) {
    holder.name.text = followUser[position].name

    holder.itemView.setOnClickListener {

    }
  }

  override fun getItemCount(): Int = followUser.size

}

class CarouselAnimationViewHolder(binding: ModelUserIconBinding) : RecyclerView.ViewHolder(binding.root) {
  val name = binding.textUserName
  val icon = binding.imageUserIcon
}

