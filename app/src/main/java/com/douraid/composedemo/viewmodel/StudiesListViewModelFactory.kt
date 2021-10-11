package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.douraid.composedemo.domain.CaseStudiesUseCase
import javax.inject.Inject

class StudiesListViewModelFactory @Inject constructor(
    private val caseStudiesUseCase: CaseStudiesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        return CaseStudiesViewModel(caseStudiesUseCase) as T
    }
}