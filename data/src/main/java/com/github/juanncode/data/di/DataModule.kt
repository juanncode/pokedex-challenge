package com.github.juanncode.data.di

import com.github.juanncode.data.datasources.local.LocalDataSource
import com.github.juanncode.data.datasources.local.RoomDataSource
import com.github.juanncode.data.datasources.remote.RemoteDataSource
import com.github.juanncode.data.datasources.remote.RetrofitDataSource
import com.github.juanncode.data.repository.PokemonRepositoryImpl
import com.github.juanncode.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: RetrofitDataSource) : RemoteDataSource

    @Binds
    abstract fun bindRoomDataSource(localDataSource: RoomDataSource) : LocalDataSource

    @Binds
    abstract fun bindRepository(repository: PokemonRepositoryImpl) : PokemonRepository

}