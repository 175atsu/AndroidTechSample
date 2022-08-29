package com.example.chart

import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.chart.databinding.FragmentChartBinding
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.time.LocalDate
import java.util.*

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
    createCombinedChart()
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
    lineDataSet.color = ContextCompat.getColor(requireContext(), R.color.spindle_accent_primary)
    // 線の太さ
    lineDataSet.lineWidth = 3f
    // 背景色を出すかの true false
    lineDataSet.setDrawFilled(true)
    // 背景色指定
    lineDataSet.fillDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.grad_line_chart)
    // 座標の大きさ
    lineDataSet.circleRadius = 5f
    // 座標の色
    lineDataSet.circleColors = listOf(ContextCompat.getColor(requireContext(), R.color.white))
    // 座標中心の表示
    lineDataSet.setDrawCircleHole(true)
    // 座標中心の大きさ(circleRadiusより小さい値)
    lineDataSet.circleHoleRadius = 4f
    // 座標中心の色
    lineDataSet.circleHoleColor =
      ContextCompat.getColor(requireContext(), R.color.spindle_accent_primary)
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
    binding.lineChart.animateXY(1000, 1000)

    // lineChart更新
    binding.lineChart.invalidate()
  }

  private fun createMonth(month: Int): Int = LocalDate.of(2020, month, 1).monthValue

  private fun createCombinedChart() {

    //表示用サンプルデータの作成//
    val weekData = listOf(
      150,
      90,
      200,
      150,
      100,
      250,
      150
    )

    val averageData = List(9) { 150 }

    //①Entryにデータ格納
    val entryList = mutableListOf<BarEntry>()
    weekData.mapIndexed { index, it ->
      entryList.add(BarEntry((index + 1).toFloat(), it.toFloat()))
    }
    val averageList = mutableListOf<Entry>()
    averageData.mapIndexed { index, it ->
      averageList.add(Entry(index.toFloat(), it.toFloat()))
    }

    // ②DataSetにデータ格納
    val barDataSet = BarDataSet(entryList, "square")
    val lineDataSet = LineDataSet(averageList, "square")

    /**
     * 棒グラフの設定
     */
    // 線の色
    barDataSet.color = ContextCompat.getColor(requireContext(), R.color.spindle_accent_primary)
    barDataSet.label = ""
    // 値の表示有無
    barDataSet.setDrawValues(false)

    /**
     * 線グラフの設定
     */
    lineDataSet.color = ContextCompat.getColor(requireContext(), R.color.spindle_accent_secondary)
    lineDataSet.lineWidth = 2f
    lineDataSet.setDrawCircles(false)
    lineDataSet.label = ""
    lineDataSet.setDrawValues(false)
    // 点線の指定
    lineDataSet.enableDashedLine(20f, 30f, 0f)


    //④BarDataにBarDataSet格納
    val barData = BarData(barDataSet)
    val averageLineData = LineData(lineDataSet)

    val combinedData = CombinedData()
    combinedData.setData(barData)
    combinedData.setData(averageLineData)

    // 棒の幅の調整
    barData.barWidth = 0.5f

    //⑤BarChartのフォーマット指定
    binding.combinedChart.apply {
      // Zoomの制御
      setScaleEnabled(false)
      // 棒グラフの左下のマーカーの制御
      legend.isEnabled = false
      // 右下のdescription labelの制御
      description.isEnabled = false

      // x軸設定
      xAxis.apply {
        isEnabled = true
        textColor = Color.BLACK
        position = XAxisPosition.BOTTOM
        valueFormatter = object : ValueFormatter() {

          override fun getFormattedValue(value: Float): String {
            // value == 0の時折線グラフのindex0に当たるのでreturnする
            if (value.toInt() == 0) return ""
            if (weekData.size >= value) {
              val simpleDateFormat = SimpleDateFormat("M/d", Locale.getDefault())
              val entriesTimestampMills: MutableList<Long> = mutableListOf(
                1614524400000,  // 2021/03/01 00:00:00
                1614610800000,  // 2021/03/02 00:00:00
                1614697200000,  // 2021/03/03 00:00:00
                1614783600000,  // 2021/03/04 00:00:00
                1614870000000,  // 2021/03/05 00:00:00
                1614956400000,  // 2021/03/06 00:00:00
                1615042800000   // 2021/03/07 00:00:00
              )
              // value には 0, 1, 2... という index が入ってくるので
              // index からタイムスタンプを取得する
              val timestampMills = entriesTimestampMills[value.toInt() - 1]
              val date = Date(timestampMills)
              return simpleDateFormat.format(date)
            } else {
              return ""
            }
          }
        }
        axisMinimum = 0f

      }
      // y軸設定
      axisRight.isEnabled = false
      axisLeft.apply {
        textColor = ContextCompat.getColor(requireContext(), R.color.black)
      }

      data = combinedData
      // 選択ハイライトの制御
      data.isHighlightEnabled = false
    }

    // アニメーション
    binding.combinedChart.animateXY(1000, 1000)

    binding.combinedChart.invalidate()
  }
}
