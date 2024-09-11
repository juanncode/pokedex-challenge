package com.github.juanncode.pokedex_challenge.di

import com.github.juanncode.pokedex_challenge.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class AppModule {
//    @Provides
//    @Singleton
//    fun provideApi(retrofit: Retrofit): ApiService {
//        return retrofit.create(ApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//        val okHttpClient = HttpLoggingInterceptor().run {
//            level = HttpLoggingInterceptor.Level.BODY
//            OkHttpClient.Builder().addInterceptor(this).build()
//        }
//        return Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl(BuildConfig.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}

