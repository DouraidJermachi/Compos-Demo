package com.douraid.composedemo.di

import com.douraid.composedemo.config.ConfigProviderImpl
import com.douraid.composedemo.utils.log.CrashlyticsLogger
import com.douraid.composedemo.config.ConfigProvider
import com.douraid.composedemo.utils.log.RemoteLogger
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Reusable
    fun provideConfigProvider(): ConfigProvider = ConfigProviderImpl

    @Provides
    @Reusable
    fun provideRemoteLogger(): RemoteLogger = CrashlyticsLogger
}