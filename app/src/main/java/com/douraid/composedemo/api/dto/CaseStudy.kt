package com.douraid.composedemo.api.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CaseStudy(
    val id: Int,
    val client: String?,
    val teaser: String,
    val vertical: String,
    val isEnterprise: Boolean,
    val title: String,
    val heroImageUrl: String?
) : Parcelable