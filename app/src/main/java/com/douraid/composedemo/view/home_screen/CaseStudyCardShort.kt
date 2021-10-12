package com.douraid.composedemo.view.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.utils.image.NetworkImage
import com.douraid.composedemo.view.utils.XSmallSpacer
import com.douraid.composedemo.view.utils.XXSmallSpacer

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CaseStudyCardShort(
    navController: NavController,
    caseStudy: CaseStudy,
    isMainScreen: Boolean
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(320.dp),
        onClick = {
            if (isMainScreen) navController.navigate("details")
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            XXSmallSpacer()

            CaseStudyTitle(caseStudy.client)

            XSmallSpacer()

            caseStudy.heroImageUrl?.let {
                NetworkImage(
                    heroImageUrl = it,
                    contentDescription = "${caseStudy.title}, Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(240.dp)
                        .padding(horizontal = 16.dp)
                )
            }

//            Image(
//                painter = painterResource(id = R.drawable.image_place_holder),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .heightIn(240.dp)
//                    .padding(horizontal = 16.dp)
//            )

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

            if (isMainScreen) {
                TeaserText(caseStudy.teaser)
                XSmallSpacer()
            }
        }
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

@Composable
private fun TeaserText(teaser: String) = Text(
    text = teaser,
    style = MaterialTheme.typography.h2,
    modifier = Modifier
        .padding(horizontal = 16.dp)
)

@Preview
@Composable
private fun PreviewLightCaseStudyCard() {
    ComposeDemoTheme(darkTheme = false) {
        CaseStudyCardShort(
            navController = rememberNavController(),
            caseStudy = caseStudyForPreview,
            isMainScreen = true
        )
    }
}

@Preview
@Composable
private fun PreviewDarkCaseStudyCard() {
    ComposeDemoTheme(darkTheme = true) {
        CaseStudyCardShort(
            navController = rememberNavController(),
            caseStudy = caseStudyForPreview,
            isMainScreen = true
        )
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