package com.example.androidtechsample.ui.groupie.carousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtechsample.R
import com.example.androidtechsample.databinding.FragmentGroupieCarouselBinding
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupieCarouselFragment : Fragment(), GroupieCarouselItem.Listener {

  private lateinit var binding: FragmentGroupieCarouselBinding
  private val viewModel: GroupieCarouselViewModel by viewModels()
  private val rainbow200: IntArray by lazy { resources.getIntArray(R.array.rainbow_200) }
  private lateinit var adapter: GroupieAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentGroupieCarouselBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    adapter = GroupieAdapter()
    binding.apply {
      recyclerView.adapter = adapter
      recyclerView.layoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    viewModel.itemList.observe(viewLifecycleOwner) {
      adapter.update(it)
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.fetchData(rainbow200, this)
  }

  override fun onItemClose(position: Int) {
    adapter.removeGroupAtAdapterPosition(position)
  }
}
