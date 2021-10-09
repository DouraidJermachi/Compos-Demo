package com.douraid.composedemo.api

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyDetails
import retrofit2.http.GET

interface CaseStudiesApi {

    companion object {
        const val CASE_STUDIES_ENDPOINT = "v1/caseStudies.json"
        const val CASE_STUDY_DETAILS_ENDPOINT = "v1/caseStudies.json"
    }

    @GET(CASE_STUDIES_ENDPOINT)
    suspend fun getCaseStudies(): List<CaseStudy>

    @GET(CASE_STUDY_DETAILS_ENDPOINT)
    suspend fun getCaseStudyDetails(): List<CaseStudyDetails>
}