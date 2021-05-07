package com.example.androidtechsample.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentMotionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MotionFragment : Fragment() {

  private lateinit var binding: FragmentMotionBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMotionBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      toTopSwipe.setOnClickListener {
        findNavController().navigate(R.id.fragment_motion_top_swipe)
      }
      toSideSwipe.setOnClickListener {
        findNavController().navigate(R.id.to_fragment_motion_side_swipe)
      }
      toCustomSwipe.setOnClickListener {
        findNavController().navigate(R.id.to_fragment_motion_custom)
      }
    }
  }
}
