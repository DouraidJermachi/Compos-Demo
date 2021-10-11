package com.douraid.composedemo.view.home_screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.douraid.composedemo.api.dto.CaseStudy

@Composable
fun CaseStudiesHorizontalRow(caseStudies: List<CaseStudy>) {
    Row(//todo use LazyRow instead
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(start = 16.dp)
    ) {
        caseStudies.forEach { caseStudy ->
            CaseStudyCardMini(caseStudy = caseStudy)
        }
    }
}