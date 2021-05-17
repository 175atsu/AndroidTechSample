package com.example.androidtechsample.ui.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentMotionSideSwipeBinding

class MotionSideSwipeFragment : Fragment() {

  private lateinit var binding: FragmentMotionSideSwipeBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMotionSideSwipeBinding.inflate(inflater)
    return binding.root
  }
}
