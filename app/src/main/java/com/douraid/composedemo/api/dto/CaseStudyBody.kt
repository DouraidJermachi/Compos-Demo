package com.douraid.composedemo.api.dto

sealed class CaseStudyBody {
    data class BodyText(val value: String) : CaseStudyBody()
    data class BodyImage(val value: String) : CaseStudyBody()
}