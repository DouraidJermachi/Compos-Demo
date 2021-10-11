package com.douraid.composedemo.domain

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.studies.CaseStudyRepository
import com.douraid.composedemo.network.NetworkApiRepositoryException
import com.douraid.composedemo.network.Type.Connection
import javax.inject.Inject

class CaseStudiesUseCase @Inject constructor(
    private val caseStudyRepository: CaseStudyRepository
) {

    suspend fun execute(): UseCaseResult<List<CaseStudy>> =
        try {
            val caseStudies = caseStudyRepository.getCaseStudyList()
            UseCaseResult.SuccessResult(caseStudies)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }
}