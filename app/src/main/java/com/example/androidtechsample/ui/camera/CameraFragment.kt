package com.example.androidtechsample.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.view.LifecycleCameraController
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {

  private lateinit var binding: FragmentCameraBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentCameraBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val cameraController = LifecycleCameraController(requireContext())
    cameraController.bindToLifecycle(viewLifecycleOwner)
    binding.viewFinder.controller = cameraController
  }
}
