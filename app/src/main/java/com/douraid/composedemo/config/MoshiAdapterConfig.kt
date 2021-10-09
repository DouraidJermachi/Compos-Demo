package com.douraid.composedemo.config

import com.douraid.composedemo.api.studies.mapper.BodyElementResponseMapper
import com.douraid.composedemo.api.studies.mapper.CaseStudyBodyMapper
import com.douraid.composedemo.api.studies.mapper.CaseStudyDetailMapper
import com.douraid.composedemo.api.studies.mapper.CaseStudyDetailsListMapper
import com.douraid.composedemo.api.studies.mapper.CaseStudyListMapper
import com.douraid.composedemo.api.studies.mapper.CaseStudyMapper
import com.douraid.composedemo.api.studies.mapper.CaseStudySectionMapper
import com.squareup.moshi.Moshi

/**
 * Internal function that provides Moshi setup with all required mappers for use in both the
 * Network modules and unit tests.
 */
object MoshiAdapterConfig {
    fun getMoshiConfig(): Moshi =
        Moshi.Builder()
            .addCaseStudyMappers()
            .build()

    private fun Moshi.Builder.addCaseStudyMappers() =
        this.add(BodyElementResponseMapper)
            .add(CaseStudyListMapper)
            .add(CaseStudyMapper)
            .add(CaseStudyDetailsListMapper)
            .add(CaseStudyDetailMapper)
            .add(CaseStudySectionMapper)
            .add(CaseStudyBodyMapper)
}
