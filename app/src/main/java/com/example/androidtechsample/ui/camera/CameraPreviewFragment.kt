package com.example.androidtechsample.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentCameraPreviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraPreviewFragment : Fragment() {

  private lateinit var binding: FragmentCameraPreviewBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentCameraPreviewBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}
