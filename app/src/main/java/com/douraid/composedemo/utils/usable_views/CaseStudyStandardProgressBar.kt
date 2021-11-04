package com.douraid.composedemo.utils.usable_views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.douraid.composedemo.ui.theme.ComposeDemoTheme


@Composable
fun CaseStudyStandardProgressBar() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Color.Green
            )
        }

    }
}

@Preview
@Composable
private fun PreviewLightStandardProgressBar() {
    ComposeDemoTheme(darkTheme = false) {

        CaseStudyStandardProgressBar()
    }
}

@Preview
@Composable
private fun PreviewDarkStandardProgressBar() {
    ComposeDemoTheme(darkTheme = true) {
        CaseStudyStandardProgressBar()
    }
}