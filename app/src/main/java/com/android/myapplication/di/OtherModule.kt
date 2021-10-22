package com.android.myapplication.di

import android.app.Application
import com.android.myapplication.ui.user.model.AccessLocalData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *Created by Nivetha S on 22-10-2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class OtherModule {

    @Provides
    fun providesAccessStorage(): AccessLocalData {
        return AccessLocalData()
    }
}