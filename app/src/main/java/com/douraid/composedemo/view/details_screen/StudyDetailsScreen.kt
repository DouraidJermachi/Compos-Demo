package com.douraid.composedemo.view.details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            CaseStudyCardShort(
                navController = navController,
                caseStudy = caseStudy,
                isMainScreen = false
            )

            caseStudyDetails.sections.forEach { section ->
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

private val caseStudyDetailsForPreview: CaseStudyDetails
    get() = CaseStudyDetails(
        id = 1,
        sections = sectionList
    )

private val sectionList: List<CaseStudySection>
    get() = listOf(
        CaseStudySection(title = "First Section Title", body = studyBodyList),
        CaseStudySection(title = "Second Section Title", body = studyBodyList),
        CaseStudySection(title = "Third Section Title", body = studyBodyList),
        CaseStudySection(title = null, body = studyBodyList)
    )

private val studyBodyList: List<CaseStudyBody>
    get() = listOf(
        CaseStudyBody.BodyText("This is the first body text that the section has"),
        CaseStudyBody.BodyImage("https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/cs_ms_hero_image-2x.jpg"),
        CaseStudyBody.BodyText("This is the second body text that the section has"),
        CaseStudyBody.BodyText("This is the third body text that the section has"),
        CaseStudyBody.BodyImage("https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/cs_ms_hero_image-2x.jpg")
    )

private val caseStudyForPreview: CaseStudy
    get() = CaseStudy(
        id = 1,
        client = "TfL",
        teaser = "Testing Tube brakes, with TfL Decelerator",
        vertical = "Public Sector",
        isEnterprise = true,
        title = "A World-First For Apple iPad",
        heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/decelerator_header-image-2x.jpg"
    )