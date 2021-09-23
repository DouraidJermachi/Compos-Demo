package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douraid.composedemo.model.UsersListState
import com.douraid.composedemo.model.UsersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersListViewModel(
    private val usersRepository: UsersRepository
):ViewModel() {
    private val _viewState = MutableStateFlow(UsersListState())
    val  viewState:StateFlow<UsersListState> = _viewState

    init {
        fetchUsersList()
    }

    private fun fetchUsersList(){
        viewModelScope.launch {
            val usersList = usersRepository.fetchUsers()

            _viewState.value = _viewState.value.copy(
                users = usersList
            )
        }
    }
}