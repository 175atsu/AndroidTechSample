package com.example.androidtechsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentMotionLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MotionLayoutFragment : Fragment() {

  private lateinit var binding: FragmentMotionLayoutBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMotionLayoutBinding.inflate(inflater)
    return binding.root
  }
}
