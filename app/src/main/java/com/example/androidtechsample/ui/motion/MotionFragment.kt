package com.example.androidtechsample.ui.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentMotionBinding
import com.example.androidtechsample.util.navigator
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
        navigator(R.id.fragment_motion_top_swipe)
      }
      toSideSwipe.setOnClickListener {
        navigator(R.id.to_fragment_motion_side_swipe)
      }
      toCustomSwipe.setOnClickListener {
        navigator(R.id.to_fragment_motion_custom)
      }
      toKeyPosition.setOnClickListener {
        navigator(R.id.to_fragment_motion_key_position)
      }
    }
  }
}
