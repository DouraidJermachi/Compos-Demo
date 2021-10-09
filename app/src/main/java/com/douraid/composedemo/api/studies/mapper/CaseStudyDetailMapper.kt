package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.CaseStudyDetailResponse
import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object CaseStudyDetailMapper {

    @FromJson
    fun fromJson(caseStudyDetailResponse: CaseStudyDetailResponse): CaseStudyDetails =
        with(caseStudyDetailResponse) {
            CaseStudyDetails(
                id = id,
                sections = sections.map { CaseStudySectionMapper.fromJson(it) }
            )
        }

    @Suppress("UNUSED_PARAMETER", "unused")
    @ToJson
    fun toJson(writer: JsonWriter, caseStudyDetails: CaseStudyDetails) {
        throw UnsupportedOperationException()
    }
}