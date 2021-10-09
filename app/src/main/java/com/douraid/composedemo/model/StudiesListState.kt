package com.douraid.composedemo.model

import com.douraid.composedemo.api.dto.CaseStudy

sealed class StudiesListState {
    object Loading : StudiesListState()
    data class Loaded(val caseStudies: List<CaseStudy>) : StudiesListState()
    object GenericError : StudiesListState()
    object NetworkError : StudiesListState()
}