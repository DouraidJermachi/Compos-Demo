package com.douraid.composedemo.view

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.douraid.composedemo.api.dto.CaseStudy

private const val ID_KEY = "id"
private const val TITLE_KEY = "title"
private const val CLIENT_KEY = "client"
private const val VERTICAL_KEY = "vertical"
private const val HERO_IMAGE_URL_KEY = "heroImageUrl"

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details")
    object Search : Screen("search")

    fun withArgs(vararg args: String?): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}

val detailsScreenArguments = listOf(
    navArgument(ID_KEY) {
        type = NavType.IntType
        defaultValue = 1
    },
    navArgument(TITLE_KEY) {
        type = NavType.StringType
        defaultValue = "M&S title"
    },
    navArgument(CLIENT_KEY) {
        type = NavType.StringType
        defaultValue = "M&S"
    },
    navArgument(VERTICAL_KEY) {
        type = NavType.StringType
        defaultValue = "M&S vertical"
    },
    navArgument(HERO_IMAGE_URL_KEY) {
        type = NavType.StringType
        defaultValue = "M&S hero image url"
    }
)

val NavBackStackEntry.getCaseStudy: CaseStudy?
    get() = arguments?.let {
        CaseStudy(
            id = it.getInt(ID_KEY),
            title = it.getString(TITLE_KEY)!!,
            client = it.getString(CLIENT_KEY),
            heroImageUrl = it.getString(HERO_IMAGE_URL_KEY)?.replace('*', '/'),
            vertical = it.getString(VERTICAL_KEY)!!,
            teaser = null,
            isEnterprise = true
        )
    }
