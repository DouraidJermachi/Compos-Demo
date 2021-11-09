package com.douraid.composedemo.view.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.douraid.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun XXSmallSpacer() = Spacer(4.dp)

@Composable
fun XSmallSpacer() = Spacer(8.dp)

@Composable
fun SmallSpacer() = Spacer(16.dp)

@Composable
fun MediumSpacer() = Spacer(24.dp)

@Composable
fun LargeSpacer() = Spacer(32.dp)

@Composable
fun XLargeSpacer() = Spacer(40.dp)

@Composable
fun Spacer(height: Dp) = Spacer(
    modifier = Modifier
        .height(height)
        .fillMaxWidth()
)

@Preview
@Composable
private fun PreviewDarkSmallSpacer() {
    ComposeDemoTheme(darkTheme = true) {
        SmallSpacer()
    }
}

@Preview
@Composable
private fun PreviewLightSmallSpacer() {
    ComposeDemoTheme(darkTheme = false) {
        SmallSpacer()
    }
}