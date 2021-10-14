package com.douraid.composedemo.view.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.douraid.composedemo.R
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.view.utils.SmallSpacer
import com.douraid.composedemo.view.utils.XLargeSpacer
import com.douraid.composedemo.view.utils.caseStudiesListForPreview

@Composable
fun StudiesListScreen(
    navController: NavController,
    caseStudies: List<CaseStudy>,
    initialCaseStudy: CaseStudy = caseStudies.first()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val selectedCaseStudy = remember { mutableStateOf(initialCaseStudy) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            XLargeSpacer()

            SearchInput()

            ScreenTitle("Case Studies")

            SmallSpacer()

            val onSelectCaseStudy: (CaseStudy) -> Unit = { caseStudy ->
                selectedCaseStudy.value = caseStudy
            }
            CaseStudiesHorizontalRow(caseStudies, onSelectCaseStudy, selectedCaseStudy.value)

            SmallSpacer()

            CaseStudyCardShort(navController, selectedCaseStudy.value, true)

        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "search icon",
                modifier = Modifier
                    .size(18.dp)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Composable
private fun LogoImage() {
    //We could change icons depending on the theme
    val isLight = MaterialTheme.colors.isLight
    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Logo image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun PreviewLightStudiesListScreen() {
    ComposeDemoTheme(darkTheme = false) {
        StudiesListScreen(
            navController = rememberNavController(),
            caseStudies = caseStudiesListForPreview
        )
    }
}

@Preview
@Composable
private fun PreviewDarkStudiesListScreen() {
    ComposeDemoTheme(darkTheme = true) {
        StudiesListScreen(
            navController = rememberNavController(),
            caseStudies = caseStudiesListForPreview
        )
    }
}