package com.douraid.composedemo.api.injection

import android.app.Activity
import com.douraid.composedemo.api.dto.CaseStudy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class StudyDetailsModule {

    companion object {
        @Provides
        @ActivityScoped
        internal fun provideCaseStudy(activity: Activity): CaseStudy = CaseStudy(
            id = 8,
            client = "M&S",
            teaser = "Building a new payments experience for a high street icon",
            vertical = "Retail",
            isEnterprise = false,
            title = "Rapidly Delivering A New Service For A High Street Icon",
            heroImageUrl = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/cs_ms_hero_image-2x.jpg"

        )
    }
}