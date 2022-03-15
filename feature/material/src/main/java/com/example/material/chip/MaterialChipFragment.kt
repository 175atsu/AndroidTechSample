package com.example.material.chip

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.material.R
import com.example.material.databinding.FragmentMaterialChipBinding

class MaterialChipFragment : Fragment() {

  private lateinit var binding: FragmentMaterialChipBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.Material3Theme)
    val localInflater = inflater.cloneInContext(contextThemeWrapper)
    binding = FragmentMaterialChipBinding.inflate(localInflater)
    return binding.root
  }
}
