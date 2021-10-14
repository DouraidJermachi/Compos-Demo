package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.domain.CaseStudyDetailsUseCase
import com.douraid.composedemo.domain.UseCaseResult
import com.douraid.composedemo.model.StudyDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StudyDetailsViewModel(
    private val caseStudyDetailsUseCase: CaseStudyDetailsUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<StudyDetailsState> =
        MutableStateFlow(StudyDetailsState.Loading)
    val viewState: StateFlow<StudyDetailsState> = _viewState

    fun loadStudyDetails(caseStudy: CaseStudy) {

        viewModelScope.launch {
            _viewState.value =
                when (val result = caseStudyDetailsUseCase.execute(caseStudy.id)) {
                    is UseCaseResult.SuccessResult -> StudyDetailsState.Loaded(
                        caseStudy,
                        result.value
                    )
                    is UseCaseResult.NetworkErrorResult -> StudyDetailsState.NetworkError
                    is UseCaseResult.GenericErrorResult -> StudyDetailsState.GenericError
                }
        }
    }
}