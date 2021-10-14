package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.douraid.composedemo.domain.CaseStudyDetailsUseCase
import javax.inject.Inject

class StudyDetailsViewModelFactory @Inject constructor(
    private val caseStudyDetailsUseCase: CaseStudyDetailsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        StudyDetailsViewModel(caseStudyDetailsUseCase) as T
}