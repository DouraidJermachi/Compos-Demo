package com.douraid.composedemo.api.studies

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.douraid.composedemo.network.NetworkApiRepositoryException

interface CaseStudyRepository {

    @Throws(NetworkApiRepositoryException::class)
    suspend fun getCaseStudyList(): List<CaseStudy>

    @Throws(NetworkApiRepositoryException::class, NoSuchElementException::class)
    suspend fun getCaseStudyDetails(caseStudyId: Int): CaseStudyDetails
}