package com.example.androidtechsample.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

  }
}
