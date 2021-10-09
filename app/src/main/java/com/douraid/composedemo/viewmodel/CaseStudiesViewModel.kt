package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douraid.composedemo.domain.GetCaseStudiesUseCase
import com.douraid.composedemo.domain.UseCaseResult
import com.douraid.composedemo.model.StudiesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CaseStudiesViewModel(
    private val getCaseStudiesUseCase: GetCaseStudiesUseCase
) : ViewModel() {
    private val _viewState: MutableStateFlow<StudiesListState> =
        MutableStateFlow(StudiesListState.Loading)
    val viewState: StateFlow<StudiesListState> = _viewState

    init {
        loadCaseStudies()
    }

    private fun loadCaseStudies() {
        viewModelScope.launch {
            _viewState.value = when (val result = getCaseStudiesUseCase.execute()) {
                is UseCaseResult.SuccessResult -> StudiesListState.Loaded(result.value)
                is UseCaseResult.NetworkErrorResult -> StudiesListState.NetworkError
                is UseCaseResult.GenericErrorResult -> StudiesListState.GenericError
            }
        }
    }
}