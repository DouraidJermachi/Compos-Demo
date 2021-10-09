package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.douraid.composedemo.domain.GetCaseStudiesUseCase
import javax.inject.Inject

class StudiesListViewModelFactory@Inject constructor(
    private val getCaseStudiesUseCase: GetCaseStudiesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        return CaseStudiesViewModel(getCaseStudiesUseCase) as T
    }
}