package com.douraid.composedemo.config

object ConfigProviderImpl : BaseCommonConfigProvider() {

    override val apiBaseUrl =
        "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/"
}