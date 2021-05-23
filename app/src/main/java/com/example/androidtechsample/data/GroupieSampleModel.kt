package com.example.androidtechsample.data

import com.example.androidtechsample.R
import javax.inject.Inject

class GroupieSampleModel @Inject constructor() {

  val playgroundModel = listOf(
    GroupiePlaygroundModel("BasicView", R.id.to_fragment_groupie_basic)
  )

  val sampleBasicList = listOf(
    "りんご",
    "みかん",
    "ばなな",
    "メロン",
    "スイカ",
    "ぶどう",
    "マスカット",
  )
}
