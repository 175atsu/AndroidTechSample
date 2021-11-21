package com.example.material

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.material.databinding.FragmentMaterialBinding

class MaterialFragment : Fragment() {

  private lateinit var binding: FragmentMaterialBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.Material3Theme)
    val localInflater = inflater.cloneInContext(contextThemeWrapper)
    binding = FragmentMaterialBinding.inflate(localInflater)
    return binding.root
  }
}
