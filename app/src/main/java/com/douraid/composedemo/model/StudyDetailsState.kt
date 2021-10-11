package com.douraid.composedemo.model

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyDetails

sealed class StudyDetailsState {

    object Loading : StudyDetailsState()
    data class Loaded(
        val caseStudy: CaseStudy,
        val caseStudyDetails: CaseStudyDetails
    ) : StudyDetailsState()

    object GenericError : StudyDetailsState()
    object NetworkError : StudyDetailsState()
}