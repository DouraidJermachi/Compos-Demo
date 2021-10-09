package com.douraid.composedemo.config

interface ConfigProvider {

    val isDebug: Boolean

    val apiBaseUrl: String

    val mainHeroImageUrl: String
}