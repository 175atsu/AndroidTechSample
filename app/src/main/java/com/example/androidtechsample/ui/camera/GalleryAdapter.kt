package com.example.androidtechsample.ui.camera

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechsample.databinding.ModelGalleryImageBinding

class GalleryAdapter(
  private val list: List<Uri>
) : RecyclerView.Adapter<GalleryViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ModelGalleryImageBinding.inflate(inflater, parent, false)
    return GalleryViewHolder(binding)
  }

  override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
    Log.d("log0",list.size.toString())
    holder.thumbnail.setImageURI(list[2])
  }

  override fun getItemCount(): Int = list.size
}
