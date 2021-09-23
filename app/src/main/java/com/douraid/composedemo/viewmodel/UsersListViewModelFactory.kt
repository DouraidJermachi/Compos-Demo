package com.douraid.composedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.douraid.composedemo.model.InMemoryUsersServices

class UsersListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = InMemoryUsersServices()

        @Suppress("UNCHECKED_CAST")
        return UsersListViewModel(repository) as T
    }
}