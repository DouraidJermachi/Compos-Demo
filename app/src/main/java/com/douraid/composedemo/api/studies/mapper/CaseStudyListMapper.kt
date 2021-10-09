package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyListResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object CaseStudyListMapper {

    @FromJson
    fun fromJson(caseStudyListResponse: CaseStudyListResponse): List<CaseStudy> {
        return caseStudyListResponse.caseStudies.map { CaseStudyMapper.fromJson(it) }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: List<CaseStudy>?) {
        throw UnsupportedOperationException()
    }
}