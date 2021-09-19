package com.example.androidtechsample.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechsample.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {

  private lateinit var binding: FragmentGalleryBinding
  private val viewModel: GalleryViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentGalleryBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val imageList = viewModel.hoge(requireContext())
    val adapter = GalleryAdapter(imageList)
    with(binding.galleryRecycler) {
      this.adapter = adapter
      layoutManager = GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
    }
  }
}
