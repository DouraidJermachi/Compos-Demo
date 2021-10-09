package com.douraid.composedemo.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class CaseStudyListResponse(
    @Json(name = "case_studies")
    val caseStudies: List<CaseStudyResponse>
)

@JsonClass(generateAdapter = true)
internal data class CaseStudyResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "client") val client: String?,
    @Json(name = "teaser") val teaser: String,
    @Json(name = "vertical") val vertical: String,
    @Json(name = "is_enterprise") val isEnterprise: Boolean,
    @Json(name = "title") val title: String,
    @Json(name = "hero_image") val heroImageUrl: String?
)