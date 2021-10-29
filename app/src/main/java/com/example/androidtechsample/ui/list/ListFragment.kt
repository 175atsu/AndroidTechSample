package com.example.androidtechsample.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtechsample.R
import com.example.androidtechsample.data.followUserMock
import com.example.androidtechsample.databinding.FragmentListBinding
import com.example.core.util.displayWidth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(),
  CarouselAnimationAdapter.Listener {

  companion object {
    const val NO_SELECT = -1
  }

  private lateinit var binding: FragmentListBinding
  private val viewModel: ListViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val adapter = CarouselAnimationAdapter(followUserMock, this)
    with(binding) {
      recyclerView.adapter = adapter
    }

    viewModel.followUserState.observe(viewLifecycleOwner) {
      if (it.selectPosition != NO_SELECT) {
        binding.textLabel.text = followUserMock[it.selectPosition].name
      } else {
        binding.textLabel.text = resources.getText(R.string.list_all)
      }
    }
  }

  override fun itemClick(position: Int, centerPosition: Int) {
    viewModel.setPosition(position)
    val halfWidth = requireContext().displayWidth / 2
    binding.recyclerView.smoothScrollBy(centerPosition - halfWidth, 0)
  }
}
