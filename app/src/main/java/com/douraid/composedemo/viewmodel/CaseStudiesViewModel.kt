package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douraid.composedemo.domain.CaseStudiesUseCase
import com.douraid.composedemo.domain.UseCaseResult
import com.douraid.composedemo.model.StudiesListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CaseStudiesViewModel(
    private val caseStudiesUseCase: CaseStudiesUseCase
) : ViewModel() {
    private val _viewState: MutableStateFlow<StudiesListState> =
        MutableStateFlow(StudiesListState.Loading)
    val viewState: StateFlow<StudiesListState> = _viewState

    init {
        loadCaseStudies()
    }

    private fun loadCaseStudies() {
        viewModelScope.launch {
            _viewState.value = when (val result = caseStudiesUseCase.execute()) {
                is UseCaseResult.SuccessResult -> StudiesListState.Loaded(result.value)
                is UseCaseResult.NetworkErrorResult -> StudiesListState.NetworkError
                is UseCaseResult.GenericErrorResult -> StudiesListState.GenericError
            }
        }
    }
}