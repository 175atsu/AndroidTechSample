package com.example.androidtechsample.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.CameraSelector.DEFAULT_FRONT_CAMERA
import androidx.camera.view.LifecycleCameraController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtechsample.databinding.FragmentCameraBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraFragment : Fragment() {

  private lateinit var binding: FragmentCameraBinding
  private val viewMode: CameraViewModel by viewModels()

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
    binding.cameraPreview.controller = cameraController
    with(binding) {
      cameraPreview.controller = cameraController
      imageHeaderChangeFrontBack.setOnClickListener {
        viewMode.changeCameraSelector()
      }
    }

    with(viewMode) {
      hasSelectorState.observe(viewLifecycleOwner) {
        when (it) {
          CameraSelector.FRONT -> cameraController.cameraSelector = DEFAULT_FRONT_CAMERA
          CameraSelector.BACK -> cameraController.cameraSelector = DEFAULT_BACK_CAMERA
        }
      }
    }
  }
}
