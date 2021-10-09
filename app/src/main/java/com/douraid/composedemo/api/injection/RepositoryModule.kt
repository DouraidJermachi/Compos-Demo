package com.douraid.composedemo.api.injection

import com.douraid.composedemo.api.studies.CaseStudyRepository
import com.douraid.composedemo.api.studies.CaseStudyRepositoryImpl
import com.douraid.composedemo.network.NetworkApiCallDelegate
import com.douraid.composedemo.network.NetworkApiCallDelegateImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindNetworkApiExecutor(
        networkApiExecutorImpl: NetworkApiCallDelegateImpl
    ): NetworkApiCallDelegate

    @Binds
    @Singleton
    abstract fun bindCaseStudiesRepository(
        caseStudyRepositoryImpl: CaseStudyRepositoryImpl
    ): CaseStudyRepository
}