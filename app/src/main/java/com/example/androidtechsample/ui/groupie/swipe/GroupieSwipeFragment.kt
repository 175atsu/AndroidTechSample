package com.example.androidtechsample.ui.groupie.swipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentGroupieSwipeBinding
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupieSwipeFragment : Fragment() {

  private lateinit var binding: FragmentGroupieSwipeBinding
  private lateinit var adapter: GroupieAdapter
  private val viewModel: GroupieSwipeViewModel by viewModels()
  private val rainbow200: IntArray by lazy { resources.getIntArray(R.array.rainbow_200) }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentGroupieSwipeBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    adapter = GroupieAdapter()
    with(binding) {
      recyclerView.adapter = adapter
      recyclerView.layoutManager = LinearLayoutManager(context)
    }
    viewModel.itemList.observe(viewLifecycleOwner) {
      adapter.update(it)
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.fetchData(rainbow200, adapter)
  }
}
