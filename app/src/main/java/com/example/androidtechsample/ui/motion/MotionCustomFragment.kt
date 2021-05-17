package com.example.androidtechsample.ui.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentMotionCustomBinding

class MotionCustomFragment : Fragment() {

  private lateinit var binding: FragmentMotionCustomBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMotionCustomBinding.inflate(inflater)
    return binding.root
  }
}
