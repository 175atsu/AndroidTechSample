package com.example.androidtechsample.resource

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androidtechsample.R

@Composable
fun textStyleBlack() = TextStyle(
  color = colorResource(id = R.color.black)
)

@Composable
fun textStyleBlackHead1() = textStyleBlack().copy(
  fontWeight = FontWeight.Bold,
  fontSize = dimensionResource(id = R.dimen.font_size_head_1).value.sp
)

@Composable
fun textStyleBlackHead2() = textStyleBlack().copy(
  fontWeight = FontWeight.Bold,
  fontSize = dimensionResource(id = R.dimen.font_size_head_2).value.sp
)

@Composable
fun textStyleWhite() = TextStyle(
  color = colorResource(id = R.color.white)
)

@Composable
fun textStyleWhiteBody1() = textStyleWhite().copy(
  fontWeight = FontWeight.Bold,
  fontSize = dimensionResource(id = R.dimen.font_size_body1).value.sp
)
