package com.poncegamez.legoapp_pt_alternova.di

import android.content.Context
import com.poncegamez.legoapp_pt_alternova.api.LegoApi
import com.poncegamez.legoapp_pt_alternova.repository.LegosRepository
import com.poncegamez.legoapp_pt_alternova.repository.impl.LegosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    private const val IS_MOCK_ENABLED = true

    @Provides
    fun providesLegoRepository(legoApi: LegoApi, context: Context): LegosRepository {
        return LegosRepositoryImpl(legoApi, IS_MOCK_ENABLED, context)
    }
}