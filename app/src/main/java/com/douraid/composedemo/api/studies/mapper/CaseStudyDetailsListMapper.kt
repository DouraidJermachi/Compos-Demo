package com.douraid.composedemo.api.studies.mapper

import com.douraid.composedemo.api.dto.CaseDetailsListResponse
import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object CaseStudyDetailsListMapper {

    @FromJson
    fun fromJson(caseDetailsListResponse: CaseDetailsListResponse): List<CaseStudyDetails> =
        caseDetailsListResponse.caseStudies.map { CaseStudyDetailMapper.fromJson(it) }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: List<CaseStudyDetails>?) {
        throw UnsupportedOperationException()
    }
}