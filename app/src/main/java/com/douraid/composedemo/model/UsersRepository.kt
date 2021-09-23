package com.douraid.composedemo.model

interface UsersRepository {
    suspend fun fetchUsers():List<UserModel>
}