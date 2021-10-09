package com.douraid.composedemo.api.studies

import com.douraid.composedemo.api.CaseStudiesApi
import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.douraid.composedemo.network.NetworkApiCallDelegate
import javax.inject.Inject

class CaseStudyRepositoryImpl @Inject constructor(
    private val caseStudiesApi: CaseStudiesApi,
    private val networkApiCallDelegate: NetworkApiCallDelegate
) : CaseStudyRepository, NetworkApiCallDelegate by networkApiCallDelegate {

    override suspend fun getCaseStudyList() =
        executeApiCall { caseStudiesApi.getCaseStudies() }

    override suspend fun getCaseStudyDetails(caseStudyId: Int): CaseStudyDetails =
        executeApiCall { caseStudiesApi.getCaseStudyDetails() }.first { it.id == caseStudyId }
}