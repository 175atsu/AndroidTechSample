package com.example.androidtechsample.ui.camera

import android.content.Context
import android.graphics.Bitmap
import android.hardware.camera2.CameraManager
import android.media.MediaActionSound
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.CameraSelector.DEFAULT_FRONT_CAMERA
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentCameraBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import android.content.ContentUris
import android.net.Uri
import androidx.navigation.fragment.findNavController
import com.example.androidtechsample.util.navigator

@AndroidEntryPoint
class CameraFragment : Fragment() {

  private lateinit var binding: FragmentCameraBinding
  private val viewMode: CameraViewModel by viewModels()

  private lateinit var cameraExecutor: ExecutorService

  lateinit var btSwitch: Button
  lateinit var manager: CameraManager
  var cameraId: String = ""
  var cameraSw = false

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
    cameraExecutor = Executors.newSingleThreadExecutor()

    val cameraController = LifecycleCameraController(requireContext())
    cameraController.bindToLifecycle(viewLifecycleOwner)
    with(binding) {
      cameraPreview.controller = cameraController
      imageHeaderAspect.setOnClickListener {
        viewMode.changeCameraSize()
      }
      imageHeaderChangeFrontBack.setOnClickListener {
        viewMode.changeCameraSelector()
      }
      imageFooterLight.setOnClickListener {
        viewMode.changeCameraLight()
      }
      buttonFooterCapture.setOnClickListener {
        takePhoto(cameraController)
      }
      binding.imageFooterGallery.setOnClickListener {
        navigator(R.id.to_fragment_camera_gallery)
      }
    }

    with(viewMode) {
      hasSelectorState.observe(viewLifecycleOwner) {
        when (it) {
          CameraSelectorType.FRONT -> cameraController.cameraSelector = DEFAULT_FRONT_CAMERA
          CameraSelectorType.BACK -> cameraController.cameraSelector = DEFAULT_BACK_CAMERA
        }
      }
      hasPreviewSizeState.observe(viewLifecycleOwner) {
        val displayWidth = viewMode.getDisplayWidth(requireContext())
        when (it) {
          CameraSizeType.BASIC -> binding.cameraPreview.layoutParams.height = displayWidth / 3 * 4
          CameraSizeType.SQUARE -> binding.cameraPreview.layoutParams.height = displayWidth
        }
        binding.cameraPreview.requestLayout()
      }
      hasLightState.observe(viewLifecycleOwner) {
        when (it) {
          CameraLightType.ON -> binding.imageFooterLight.setImageResource(R.drawable.ic_flashlight_on_black_24dp)
          CameraLightType.OFF -> binding.imageFooterLight.setImageResource(R.drawable.ic_flashlight_off_black_24dp)
        }
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    cameraExecutor.shutdown()
  }

  // TODO 謎
  private fun setLight() {
    var firstTime = true
    manager =
      context?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    try {
      // トーチモードのコールバックを登録する
      manager.registerTorchCallback(
        object : CameraManager.TorchCallback() {
          override fun onTorchModeChanged(id: String, enabled: Boolean) {
            super.onTorchModeChanged(id, enabled)
            // 前面カメラのみ有効
            if (id != "0") return

            // カメラidと状態を保存する
            cameraId = id
            cameraSw = enabled

            // アプリ起動時のライトスイッチ
            if (firstTime) {
              switchLight()
              firstTime = false
            }
          }
        },
        Handler()
      )
    } catch (e: Exception) {
    }
  }

  private fun switchLight() {
//    manager.setTorchMode(cameraId, !cameraSw)
  }

  private fun takePhoto(cameraController: CameraController) {
    val outputFile = viewMode.getOutputFileOptions(requireContext())
    val sound = viewMode.createShutterSound()

    cameraController.takePicture(
      outputFile,
      ContextCompat.getMainExecutor(context),
      object : ImageCapture.OnImageSavedCallback {
        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
          Timber.d("成功")
          outputFileResults.savedUri
          sound.play(MediaActionSound.SHUTTER_CLICK)
        }

        override fun onError(exception: ImageCaptureException) {
          Timber.d(exception)
        }
      }
    )
  }
}
