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
import com.douraid.composedemo.utils.image.CoilImage
import com.douraid.composedemo.view.Screen
import com.douraid.composedemo.view.utils.XSmallSpacer
import com.douraid.composedemo.view.utils.XXSmallSpacer
import com.douraid.composedemo.view.utils.caseStudyForPreview

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
            .heightIn(if (isMainScreen) 320.dp else 240.dp),
        onClick = {
            if (isMainScreen) navController.navigate(
                Screen.Details.withArgs(
                    caseStudy.id.toString(),
                    caseStudy.title,
                    caseStudy.client,
                    caseStudy.vertical,
                    caseStudy.heroImageUrl?.replace('/', '*'),
                )
            )
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
                CoilImage(
                    url = it,
                    contentDescription = "${caseStudy.title}, Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(240.dp)
                        .padding(top = 16.dp)
                )
            }

            if (isMainScreen) {
                CaseStudyTeaser(caseStudy)
            }
        }
    }
}

@Composable
private fun CaseStudyTeaser(
    caseStudy: CaseStudy
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        caseStudy.teaser?.let {
            TeaserText(it)
            XSmallSpacer()
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