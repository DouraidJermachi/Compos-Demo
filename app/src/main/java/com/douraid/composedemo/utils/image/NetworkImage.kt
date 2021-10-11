package com.douraid.composedemo.utils.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale

@Composable
fun NetworkImage(
    heroImageUrl: String,
    contentDescription: String? = null,
    @DrawableRes defaultImage: Int = DEFAULT_PLACEHOLDER_IMAGE,
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier
) {
    val image = loadImage(
        url = heroImageUrl,
        defaultImage = defaultImage
    ).value?.asImageBitmap()
    image?.let {
        Image(
            bitmap = it,
            contentDescription = contentDescription,
            modifier = modifier
        )
    }
}