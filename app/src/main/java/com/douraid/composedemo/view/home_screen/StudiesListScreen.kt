package com.douraid.composedemo.view.home_screen

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.ui.theme.ComposeDemoTheme
import com.douraid.composedemo.view.utils.SmallSpacer
import com.douraid.composedemo.view.utils.XLargeSpacer
import com.douraid.composedemo.view.utils.caseStudiesListForPreview

@Composable
fun StudiesListScreen(
    onCaseStudyClicked: (CaseStudy) -> Unit,
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

            CaseStudyCardShort(onCaseStudyClicked, selectedCaseStudy.value, true)

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

@Preview
@Composable
private fun PreviewLightStudiesListScreen() {
    ComposeDemoTheme(darkTheme = false) {
        StudiesListScreen(
            onCaseStudyClicked = {},
            caseStudies = caseStudiesListForPreview
        )
    }
}

@Preview
@Composable
private fun PreviewDarkStudiesListScreen() {
    ComposeDemoTheme(darkTheme = true) {
        StudiesListScreen(
            onCaseStudyClicked = {},
            caseStudies = caseStudiesListForPreview
        )
    }
}