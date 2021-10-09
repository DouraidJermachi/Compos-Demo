package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.BodyElementResponse
import com.douraid.composedemo.api.dto.CaseStudyBody
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object CaseStudyBodyMapper {

    @FromJson
    fun fromJson(bodyElementResponse: BodyElementResponse): CaseStudyBody =
        when (bodyElementResponse) {
            is BodyElementResponse.TextBodyElementResponse -> CaseStudyBody.BodyText(
                bodyElementResponse.text
            )
            is BodyElementResponse.ImageBodyElementResponse -> CaseStudyBody.BodyImage(
                bodyElementResponse.imageUrl
            )
        }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: CaseStudyBody?) {
        throw UnsupportedOperationException()
    }
}