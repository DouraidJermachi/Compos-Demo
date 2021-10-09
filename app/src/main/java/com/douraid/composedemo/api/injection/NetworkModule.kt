package com.douraid.composedemo.api.injection

import com.douraid.composedemo.api.CaseStudiesApi
import com.douraid.composedemo.config.MoshiAdapterConfig.getMoshiConfig
import com.squareup.moshi.Moshi
import com.douraid.composedemo.config.ConfigProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideCaseStudiesApi(
        configProvider: ConfigProvider,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): CaseStudiesApi {
        return Retrofit.Builder()
            .baseUrl(configProvider.apiBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(CaseStudiesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(configProvider: ConfigProvider) =
        HttpLoggingInterceptor().apply { level = if (configProvider.isDebug) BODY else NONE }

    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideMoshiConfig(): Moshi = getMoshiConfig()
}