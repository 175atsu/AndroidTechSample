package com.example.androidtechsample.ui.groupie.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtechsample.databinding.FragmentGroupieBasicBinding
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupieBasicFragment : Fragment() {

  private lateinit var binding: FragmentGroupieBasicBinding
  private val viewModel: GroupieBasicViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentGroupieBasicBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val adapter = GroupieAdapter()
    with(binding) {
      lifecycleOwner = viewLifecycleOwner
      recyclerView.adapter = adapter
      recyclerView.layoutManager = LinearLayoutManager(context)
    }
    viewModel.itemList.observe(viewLifecycleOwner) {
      for (item in it) {
        adapter.add(GroupieBasicItem(item))
      }
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.fetchData()
  }
}
