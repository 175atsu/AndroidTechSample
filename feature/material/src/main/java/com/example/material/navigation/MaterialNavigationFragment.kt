package com.example.material.navigation

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.material.R
import com.example.material.databinding.FragmentMaterialNavigationBinding

class MaterialNavigationFragment : Fragment() {

  private lateinit var binding: FragmentMaterialNavigationBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.Material3Theme)
    val localInflater = inflater.cloneInContext(contextThemeWrapper)
    binding = FragmentMaterialNavigationBinding.inflate(localInflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.navigationBarAuto.setOnItemSelectedListener { item ->
      binding.navigationBarAuto.removeBadge(item.itemId)
      true
    }

    binding.buttonAddBadge.setOnClickListener {
      val badge1 = binding.navigationBarAuto.getOrCreateBadge(R.id.page_1)
      val badge2 = binding.navigationBarAuto.getOrCreateBadge(R.id.page_2)
      val badge3 = binding.navigationBarAuto.getOrCreateBadge(R.id.page_3)
      val badge4 = binding.navigationBarAuto.getOrCreateBadge(R.id.page_4)
      badge1.isVisible = true
      badge2.number = 99
      badge3.number = 999
      badge4.number = 9999
    }
  }
}
