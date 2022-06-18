package com.example.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chart.databinding.FragmentChartBinding

class ChartFragment : Fragment() {

  private lateinit var binding: FragmentChartBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentChartBinding.inflate(inflater)
    return binding.root
  }
}
