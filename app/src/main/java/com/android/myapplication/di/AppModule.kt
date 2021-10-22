package com.android.myapplication.di

import com.android.myapplication.network.ApiHelper
import com.android.myapplication.network.ApiHelperImpl
import com.android.myapplication.network.ApiService
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *Created by Nivetha S on 09-05-2021.
 */
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://reqres.in/api/")
        .client(
            OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .addInterceptor(
                    LoggingInterceptor.Builder()
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .addHeader("Header", "12jekfsd")
                        .addHeader("Header", "identity")
                        .request("Request")
                        .response("Response")
                        .build()
                )
                .build()
        )
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper


}