package com.poncegamez.legoapp_pt_alternova.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(ActivityRetainedComponent::class)

object ViewModelModule {

    @Provides
    fun providesCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

}