package com.example.chart

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.chart.databinding.FragmentChartBinding
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.time.LocalDate

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

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    createLineChart()
  }

  private fun createLineChart() {
    //表示用サンプルデータの作成//
    val follow = listOf(
      Pair(createMonth(4), 1000),
      Pair(createMonth(5), 970),
      Pair(createMonth(6), 980),
      Pair(createMonth(7), 1020),
      Pair(createMonth(8), 1130),
      Pair(createMonth(9), 1250),
      Pair(createMonth(10), 1300),
      Pair(createMonth(11), 1400),
    )

    // Entryにデータ格納
    val entryList = mutableListOf<Entry>()//1本目の線
    follow.map {
      entryList.add(
        Entry(it.first.toFloat(), it.second.toFloat())
      )
    }

    // DataSetにデータ格納
    val lineDataSet = LineDataSet(entryList, "square")
    // DataSetにフォーマット指定(3章で詳説)
    // 線の色
    lineDataSet.color = ContextCompat.getColor(requireContext(), R.color.ameba)
    // 線の太さ
    lineDataSet.lineWidth = 3f
    // 背景色を出すかの true false
    lineDataSet.setDrawFilled(true)
    // 背景色指定
    lineDataSet.fillDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.feed_red)
    // 座標の大きさ
    lineDataSet.circleRadius = 5f
    // 座標の色
    lineDataSet.circleColors = listOf(ContextCompat.getColor(requireContext(), R.color.white))
    // 座標中心の表示
    lineDataSet.setDrawCircleHole(true)
    // 座標中心の大きさ(circleRadiusより小さい値)
    lineDataSet.circleHoleRadius = 4f
    // 座標中心の色
    lineDataSet.circleHoleColor = ContextCompat.getColor(requireContext(), R.color.ameba)
    // データの値を記す。0fで記載なし。
    lineDataSet.valueTextSize = 0f
    lineDataSet.label = ""
    // 表示モード
    lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER

    //リストに格納
    val lineDataSets = mutableListOf<ILineDataSet>()
    lineDataSets.add(lineDataSet)

    // LineDataにLineDataSet格納
    val lineData = LineData(lineDataSets)
    // LineChartにLineData格納
    binding.lineChart.data = lineData
    // Chartのフォーマット指定
    binding.lineChart.apply {
      // x軸設定
      xAxis.apply {
        isEnabled = true
        textColor = Color.BLACK
        textSize = 12f
        typeface = Typeface.DEFAULT_BOLD
        position = XAxisPosition.BOTTOM
        valueFormatter = MonthValueFormatter()
        labelCount = 4

      }
      // y軸の設定
      axisRight.isEnabled = false
      axisLeft.apply {
        textSize = 12f
        typeface = Typeface.DEFAULT_BOLD
        valueFormatter = FollowValueFormatter()
      }
      // description
      description.isEnabled = false
    }
    // アニメーション
    binding.lineChart.animateXY(1000, 1000);

    // lineChart更新
    binding.lineChart.invalidate()
  }

  private fun createMonth(month: Int): Int =
    LocalDate.of(2020, month, 1).monthValue
}
