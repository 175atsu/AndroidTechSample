package com.messi.designsystem.digitalagency.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.messi.designsystem.digitalagency.DigitalAgencyTextStyle
import com.messi.designsystem.digitalagency.DigitalAgencyTheme

enum class ButtonSize(val minWidth: Dp, val height: Dp) {
  Large(minWidth = 136.dp, height = 56.dp),
  Medium(minWidth = 96.dp, height = 48.dp),
  Small(minWidth = 80.dp, height = 36.dp),
}

@Composable
fun PrimaryButton(
  text: String,
  size: ButtonSize,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  onClick: () -> Unit,
) {
  Button(
    colors = ButtonDefaults.buttonColors(
      containerColor = DigitalAgencyTheme.colors.buttonNormal,
      disabledContainerColor = DigitalAgencyTheme.colors.buttonDisabledBG
    ),
    onClick = onClick,
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .widthIn(min = size.minWidth)
      .height(size.height),
    enabled = enabled
  ) {
    Text(
      text = text,
      style = DigitalAgencyTextStyle.Button,
      color = DigitalAgencyTheme.colors.textOnFill
    )
  }
}

@Composable
fun SecondaryButton(
  text: String,
  size: ButtonSize,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  onClick: () -> Unit,
) {
  OutlinedButton(
    onClick = onClick,
    colors = ButtonDefaults.outlinedButtonColors(
      contentColor = DigitalAgencyTheme.colors.buttonNormal,
      disabledContentColor = DigitalAgencyTheme.colors.textDisabled,
    ),
    border = BorderStroke(
      width = 1.dp,
      color = if (enabled) DigitalAgencyTheme.colors.buttonNormal else DigitalAgencyTheme.colors.buttonDisabledBG
    ),
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .widthIn(min = size.minWidth)
      .height(size.height)
      .background(DigitalAgencyTheme.colors.backgroundPrimary, RoundedCornerShape(8.dp)),
    enabled = enabled
  ) {
    Text(
      text = text,
      style = DigitalAgencyTextStyle.Button,
      color = if (enabled) DigitalAgencyTheme.colors.buttonNormal else DigitalAgencyTheme.colors.textDisabled
    )
  }
}

@Composable
fun TertiaryButton(
  text: String,
  size: ButtonSize,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  onClick: () -> Unit,
) {
  TextButton(
    onClick = onClick,
    colors = ButtonDefaults.textButtonColors(
      contentColor = DigitalAgencyTheme.colors.buttonNormal,
      disabledContentColor = DigitalAgencyTheme.colors.textDisabled,
    ),
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .widthIn(min = size.minWidth)
      .height(size.height),
    enabled = enabled
  ) {
    Text(
      text = text,
      style = DigitalAgencyTextStyle.Button.copy(
        textDecoration = TextDecoration.Underline
      ),
    )
  }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
  DigitalAgencyTheme {
    PrimaryButton(text = "ラベル", size = ButtonSize.Large) {}
  }
}

@Preview
@Composable
private fun SecondaryButtonPreview() {
  DigitalAgencyTheme {
    SecondaryButton(text = "ラベル", size = ButtonSize.Large) {}
  }
}

@Preview
@Composable
private fun TertiaryButtonPreview() {
  DigitalAgencyTheme {
    TertiaryButton(text = "ラベル", size = ButtonSize.Large) {}
  }
}
