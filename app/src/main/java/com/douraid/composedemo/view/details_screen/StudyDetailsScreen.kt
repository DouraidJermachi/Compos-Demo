package com.douraid.composedemo.view.details_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyBody
import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.douraid.composedemo.api.dto.CaseStudySection
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.utils.image.NetworkImage
import com.douraid.composedemo.view.home_screen.CaseStudyCardShort
import com.douraid.composedemo.view.home_screen.ScreenTitle
import com.douraid.composedemo.view.utils.SmallSpacer
import com.douraid.composedemo.view.utils.XXSmallSpacer
import com.douraid.composedemo.view.utils.caseStudyDetailsForPreview
import com.douraid.composedemo.view.utils.caseStudyForPreview

@Composable
fun StudyDetailsScreen(
    navController: NavController,
    caseStudy: CaseStudy,
    caseStudyDetails: CaseStudyDetails
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(listOf(caseStudy)) { caseStudy ->
                CaseStudyCardShort(
                    navController = navController,
                    caseStudy = caseStudy,
                    isMainScreen = false
                )
            }
            items(caseStudyDetails.sections) { section ->
                ComposeCaseSection(section)
            }
        }
    }
}

@Composable
private fun ComposeCaseSection(section: CaseStudySection) {
    section.title?.let {
        ScreenTitle(title = it)
    }

    SmallSpacer()

    section.body.forEach { body ->
        when (body) {
            is CaseStudyBody.BodyText -> {
                Text(text = body.value)
            }
            is CaseStudyBody.BodyImage -> {
                NetworkImage(
                    heroImageUrl = body.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }

        XXSmallSpacer()

    }

    SmallSpacer()
}

@Preview
@Composable
private fun PreviewLightStudyDetailsScreen() {
    ComposeDemoTheme(darkTheme = false) {
        StudyDetailsScreen(
            navController = rememberNavController(),
            caseStudy = caseStudyForPreview,
            caseStudyDetails = caseStudyDetailsForPreview
        )
    }
}

@Preview
@Composable
private fun PreviewDarkStudyDetailsScreen() {
    ComposeDemoTheme(darkTheme = true) {
        StudyDetailsScreen(
            navController = rememberNavController(),
            caseStudy = caseStudyForPreview,
            caseStudyDetails = caseStudyDetailsForPreview
        )
    }
}