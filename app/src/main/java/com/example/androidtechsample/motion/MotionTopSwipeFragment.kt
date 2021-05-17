package com.example.androidtechsample.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentMotionTopSwipeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MotionTopSwipeFragment : Fragment() {

  private lateinit var binding: FragmentMotionTopSwipeBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMotionTopSwipeBinding.inflate(inflater)
    return binding.root
  }
}
