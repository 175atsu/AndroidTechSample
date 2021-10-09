package com.example.androidtechsample.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtechsample.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

  private lateinit var binding: FragmentListBinding

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
    val adapter = CarouselAnimationAdapter(setFollowUser())
    with(binding) {
      recyclerView.adapter = adapter
    }
  }

  private fun setFollowUser(): List<FollowUser> {
    val followUserList = mutableListOf<FollowUser>()
    for (i in 1..20) {
      followUserList.add(FollowUser.SAMPLE)
    }
    return followUserList
  }
}
