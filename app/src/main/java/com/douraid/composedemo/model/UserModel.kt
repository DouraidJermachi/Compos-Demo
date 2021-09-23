package com.douraid.composedemo.model

data class UserModel(
    val firstName: String,
    val lastName: String,
    val job: String
)

val defaultUserModels = listOf(
    UserModel(firstName = "James", lastName = "Scott", job = "Enj"),
    UserModel(firstName = "Voicu", lastName = "Klein", job = "Enj"),
    UserModel(firstName = "Nikita", lastName = "Koradiya", job = "Enj"),
    UserModel(firstName = "Bucra", lastName = "Deniz Akin", job = "dev"),
    UserModel(firstName = "Connor", lastName = "McFadden", job = "dev"),
    UserModel(firstName = "Douraid", lastName = "Jermachi", job = "dev")
)