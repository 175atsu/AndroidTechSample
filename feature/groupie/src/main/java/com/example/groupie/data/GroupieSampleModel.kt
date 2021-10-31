package com.example.groupie.data

import com.example.groupie.R
import javax.inject.Inject

class GroupieSampleModel @Inject constructor() {

  val playgroundModel = listOf(
    GroupiePlaygroundModel("BasicView", R.id.to_fragment_groupie_basic),
    GroupiePlaygroundModel("CarouselView", R.id.to_fragment_groupie_carousel),
    GroupiePlaygroundModel("SwipeView", R.id.to_fragment_groupie_swipe)
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
