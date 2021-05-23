package com.example.androidtechsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentPlaygroundBinding
import com.example.androidtechsample.util.navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaygroundFragment : Fragment() {

  private lateinit var binding: FragmentPlaygroundBinding

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
    }
  }
}
