package com.douraid.composedemo.view.utils

import com.douraid.composedemo.api.dto.CaseStudy
import com.douraid.composedemo.api.dto.CaseStudyBody
import com.douraid.composedemo.api.dto.CaseStudyDetails
import com.douraid.composedemo.api.dto.CaseStudySection

val caseStudyDetailsForPreview: CaseStudyDetails
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

val caseStudyForPreview: CaseStudy
    get() = CaseStudy(
        id = 1,
        client = "TfL",
        teaser = "Testing Tube brakes, with TfL Decelerator",
        vertical = "Public Sector",
        isEnterprise = true,
        title = "A World-First For Apple iPad",
        heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/decelerator_header-image-2x.jpg"
    )


val caseStudiesListForPreview: List<CaseStudy> = listOf(
    CaseStudy(
        id = 8,
        client = "M&S",
        teaser = "Building a new payments experience for a high street icon",
        vertical = "Retail",
        isEnterprise = false,
        title = "Rapidly Delivering A New Service For A High Street Icon",
        heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/cs_ms_hero_image-2x.jpg"
    ),
    CaseStudy(
        id = 6,
        client = "Unilever",
        teaser = "Enabling smartfast decisions inside global giant Unilever",
        vertical = "FMCG",
        isEnterprise = true,
        title = "Enabling Faster Business Decisions",
        heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/oneview-hero-2x.jpg"
    ),
    CaseStudy(
        id = 1,
        client = "TfL",
        teaser = "Testing Tube brakes, with TfL Decelerator",
        vertical = "Public Sector",
        isEnterprise = true,
        title = "A World-First For Apple iPad",
        heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/decelerator_header-image-2x.jpg"
    )
)