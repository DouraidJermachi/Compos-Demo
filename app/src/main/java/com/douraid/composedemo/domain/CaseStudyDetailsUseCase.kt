package com.douraid.composedemo.domain

import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.douraid.composedemo.api.studies.CaseStudyRepository
import com.douraid.composedemo.network.NetworkApiRepositoryException
import com.douraid.composedemo.network.Type.Connection
import javax.inject.Inject

class CaseStudyDetailsUseCase @Inject constructor(
    private val caseStudyRepository: CaseStudyRepository
) {

    suspend fun execute(caseStudyId: Int): UseCaseResult<CaseStudyDetails> =
        try {
            val caseStudyDetails = caseStudyRepository.getCaseStudyDetails(caseStudyId)
            UseCaseResult.SuccessResult(caseStudyDetails)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        } catch (throwable: Throwable) {
            UseCaseResult.GenericErrorResult
        }
}