package com.douraid.composedemo.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class CaseDetailsListResponse(
    @Json(name = "case_studies") val caseStudies: List<CaseStudyDetailResponse>
)

@JsonClass(generateAdapter = true)
internal data class CaseStudyDetailResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "sections") val sections: List<CaseStudyDetailSectionResponse>
)

@JsonClass(generateAdapter = true)
internal data class CaseStudyDetailSectionResponse(
    @Json(name = "title") val title: String?,
    @Json(name = "body_elements") val bodyElements: List<BodyElementResponse>
)

internal sealed class BodyElementResponse {

    internal data class TextBodyElementResponse(val text: String) : BodyElementResponse()

    @JsonClass(generateAdapter = true)
    internal data class ImageBodyElementResponse(
        @Json(name = "image_url") val imageUrl: String
    ) : BodyElementResponse()
}