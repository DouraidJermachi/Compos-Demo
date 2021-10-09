package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.CaseStudyDetailSectionResponse
import com.douraid.composedemo.api.dto.CaseStudySection
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object CaseStudySectionMapper {

    @FromJson
    fun fromJson(caseStudyDetailSectionResponse: CaseStudyDetailSectionResponse): CaseStudySection =
        with(caseStudyDetailSectionResponse) {
            CaseStudySection(
                title = title,
                body = bodyElements.map { CaseStudyBodyMapper.fromJson(it) }
            )
        }

    @Suppress("UNUSED_PARAMETER", "unused")
    @ToJson
    fun toJson(writer: JsonWriter, caseStudySection: CaseStudySection) {
        throw UnsupportedOperationException()
    }
}