package com.example.androidtechsample.ui.appbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidtechsample.databinding.FragmentAppbarBinding

class AppbarFragment : Fragment() {

  private lateinit var binding: FragmentAppbarBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentAppbarBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.toolbar.setNavigationOnClickListener {
      findNavController().popBackStack()
    }
    binding.back.setOnClickListener {}
    binding.materialToolbar.setNavigationOnClickListener {}
  }
}
