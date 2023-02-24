package com.example.androidtechsample.ui.chrome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentChromeCustomTabBinding

class ChromeCustomTabFragment : Fragment() {

  private lateinit var binding: FragmentChromeCustomTabBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentChromeCustomTabBinding.inflate(inflater)
    return binding.root
  }
}
