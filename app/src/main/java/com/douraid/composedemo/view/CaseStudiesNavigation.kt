package com.douraid.composedemo.view

import androidx.navigation.NavController
import com.douraid.composedemo.api.dto.CaseStudy

class CaseStudiesNavigation(
    private val navController: NavController
) {
    val navigateToDetailsScreen: (CaseStudy) -> Unit
        get() = { caseStudy ->
            navController.navigate(
                Screen.Details.withArgs(
                    caseStudy.id.toString(),
                    caseStudy.title,
                    caseStudy.client,
                    caseStudy.vertical,
                    caseStudy.heroImageUrl?.replace('/', '*'),
                )
            )
        }
}