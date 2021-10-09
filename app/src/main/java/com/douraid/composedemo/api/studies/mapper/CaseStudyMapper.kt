package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object CaseStudyMapper {

    @FromJson
    fun fromJson(caseStudyResponse: CaseStudyResponse): CaseStudy {
        with(caseStudyResponse) {
            return CaseStudy(
                id = id,
                client = client,
                teaser = teaser,
                vertical = vertical,
                isEnterprise = isEnterprise,
                title = title,
                heroImageUrl = heroImageUrl
            )
        }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: CaseStudy?) {
        throw UnsupportedOperationException()
    }
}