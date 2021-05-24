package com.example.androidtechsample.data

import com.example.androidtechsample.R
import javax.inject.Inject

class GroupieSampleModel @Inject constructor() {

  val playgroundModel = listOf(
    GroupiePlaygroundModel("BasicView", R.id.to_fragment_groupie_basic),
    GroupiePlaygroundModel("CarouselView", R.id.to_fragment_groupie_carousel)
  )

  val basicHeaderItem = listOf(
    "フルーツ",
    "動物"
  )

  val basicFruitsItems = listOf(
    "りんご",
    "みかん",
    "ばなな",
    "メロン",
    "スイカ",
    "ぶどう",
    "マスカット",
  )

  val basicAnimalItems = listOf(
    "ぞう",
    "キリン",
    "ペンギン",
    "ライオン"
  )
}
