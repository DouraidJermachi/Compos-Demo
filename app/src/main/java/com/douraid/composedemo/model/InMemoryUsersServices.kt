package com.douraid.composedemo.model

class InMemoryUsersServices : UsersRepository {
    override suspend fun fetchUsers(): List<UserModel> {
        // just returns a hardcoded list as an example, could be any data source like database or api ..
        return defaultUserModels
    }
}