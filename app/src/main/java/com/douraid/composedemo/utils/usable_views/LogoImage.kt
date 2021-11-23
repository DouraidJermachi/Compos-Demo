package com.douraid.composedemo.utils.usable_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.douraid.composedemo.R
import com.douraid.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun LogoImage(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    //We could change icons depending on the theme
    val isLight = MaterialTheme.colors.isLight
    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Logo image",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )
}

@Preview
@Composable
private fun PreviewLightLogoImage() {
    ComposeDemoTheme(darkTheme = false) {
        LogoImage(Modifier.wrapContentSize())
    }
}

@Preview
@Composable
private fun PreviewDarkLogoImage() {
    ComposeDemoTheme(darkTheme = true) {
        LogoImage(Modifier.wrapContentSize())
    }
}