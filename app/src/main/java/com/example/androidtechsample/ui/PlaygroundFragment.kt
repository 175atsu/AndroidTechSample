package com.example.androidtechsample.ui

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentPlaygroundBinding
import com.example.core.util.navigator
import com.example.core.util.shortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaygroundFragment : Fragment() {

  companion object {
    val REQUIRED_PERMISSIONS =
      arrayOf(Manifest.permission.CAMERA)
  }

  private lateinit var binding: FragmentPlaygroundBinding

  private val cameraPermissionRequestLauncher =
    registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
      if (result.all { it.value }) {
        navigator(R.id.to_fragment_camera)
      } else {
        shortToast(requireContext(), R.string.playground_permission_camera)
      }
    }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPlaygroundBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      buttonPlaygroundToDesignMock.setOnClickListener {
        navigator(R.id.to_fragment_biometric)
      }
      toMotionLayout.setOnClickListener {
        navigator(R.id.to_fragment_motion)
      }
      toGroupieView.setOnClickListener {
        navigator(R.id.to_fragment_groupie)
      }
      toSpanView.setOnClickListener {
        navigator(R.id.to_fragment_span)
      }
      toNotificationView.setOnClickListener {
        navigator(R.id.to_fragment_notification)
      }
      toListView.setOnClickListener {
        navigator(R.id.to_fragment_list)
      }
      toCameraView.setOnClickListener {
        cameraPermissionRequestLauncher.launch(REQUIRED_PERMISSIONS)
      }
      toComposeView.setOnClickListener {
        navigator(R.id.to_fragment_compose)
      }
      toMaterialView.setOnClickListener {
        navigator(R.id.to_fragment_material)
      }
      toChromeCustomTab.setOnClickListener {
        navigator(R.id.to_fragment_chrome_custom_tab)
      }
      toAppbar.setOnClickListener {
        navigator(R.id.to_fragment_appbar)
      }
    }
  }
}
