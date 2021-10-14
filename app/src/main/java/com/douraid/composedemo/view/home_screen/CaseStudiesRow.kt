package com.douraid.composedemo.view.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.model.SelectionState

@Composable
fun CaseStudiesHorizontalRow(
    caseStudies: List<CaseStudy>,
    onSelectCaseStudy: (CaseStudy) -> Unit,
    selectedCaseStudy: CaseStudy
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(start = 16.dp)
    ) {
        items(caseStudies) { caseStudy ->
            val selectionState =
                if (selectedCaseStudy.id == caseStudy.id) SelectionState.Selected else SelectionState.Unselected
            CaseStudyCardMini(
                caseStudy = caseStudy,
                onSelectCaseStudy = onSelectCaseStudy,
                selectionState = selectionState
            )
        }
    }
}