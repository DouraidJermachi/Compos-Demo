package com.douraid.composedemo.view.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.utils.image.NetworkImage
import com.douraid.composedemo.view.utils.SmallSpacer
import com.douraid.composedemo.view.utils.XXSmallSpacer

@Composable
fun CaseStudyCardShort(caseStudy: CaseStudy) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CaseStudyTitle(caseStudy.client)

        SmallSpacer()

        caseStudy.heroImageUrl?.let {
            NetworkImage(
                heroImageUrl = it,
                contentDescription = "${caseStudy.title}, Image",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            )
        }

        XXSmallSpacer()

        Text(
            text = caseStudy.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Text(
            text = caseStudy.vertical,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 16.dp)
                .align(Alignment.End)
        )
    }
}

@Composable
private fun CaseStudyTitle(client: String?) {
    client?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(horizontal = 16.dp),
        )
    }
}


@Preview
@Composable
private fun PreviewLightCaseStudyCard() {
    ComposeDemoTheme(darkTheme = false) {
        CaseStudyCardShort(caseStudy = caseStudyForPreview)
    }
}

@Preview
@Composable
private fun PreviewDarkCaseStudyCard() {
    ComposeDemoTheme(darkTheme = true) {
        CaseStudyCardShort(caseStudy = caseStudyForPreview)
    }
}

private val caseStudyForPreview = CaseStudy(
    id = 1,
    client = "TfL",
    teaser = "Testing Tube brakes, with TfL Decelerator",
    vertical = "Public Sector",
    isEnterprise = true,
    title = "A World-First For Apple iPad",
    heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/decelerator_header-image-2x.jpg"
)