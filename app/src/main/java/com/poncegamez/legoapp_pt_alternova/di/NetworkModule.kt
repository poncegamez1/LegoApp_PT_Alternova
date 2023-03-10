package com.poncegamez.legoapp_pt_alternova.di

import com.poncegamez.legoapp_pt_alternova.api.LegoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {
     private const val BASE_URL = "https://489a19f7-f7d2-426a-8361-230148034a79.mock.pstmn.io"

     @Provides
     fun providesOkHttpClient(): OkHttpClient{
          return OkHttpClient.Builder()
               .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
               .build()
     }

     @Provides
     fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
          return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
               .build()
     }

     @Provides
     fun providesLegoApi(retrofit: Retrofit): LegoApi{
          return retrofit.create(LegoApi::class.java)
     }

}