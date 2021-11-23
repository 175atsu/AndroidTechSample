package com.example.material.dialog

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.material.R
import com.example.material.databinding.FragmentMaterialDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MaterialDialogFragment : Fragment() {

  private lateinit var binding: FragmentMaterialDialogBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val contextThemeWrapper: Context = ContextThemeWrapper(activity, R.style.Material3Theme)
    val localInflater = inflater.cloneInContext(contextThemeWrapper)
    binding = FragmentMaterialDialogBinding.inflate(localInflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.buttonBasicDialog.setOnClickListener {
      MaterialAlertDialogBuilder(binding.root.context)
        .setIcon(R.drawable.ic_add_black_24dp)
        .setTitle(resources.getString(R.string.material_dialog_title))
        .setMessage(resources.getString(R.string.material_dialog_description))
        .setNeutralButton(resources.getString(R.string.material_dialog_cancel)) { _, _ ->
        }
        .setNegativeButton(resources.getString(R.string.material_dialog_decline)) { _, _ ->
        }
        .setPositiveButton(resources.getString(R.string.material_dialog_accept)) { _, _ ->
        }
        .show()
    }
  }
}
