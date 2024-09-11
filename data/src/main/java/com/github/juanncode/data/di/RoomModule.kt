package com.github.juanncode.data.di

import android.content.Context
import androidx.room.Room
import com.github.juanncode.data.database.PokemonDao
import com.github.juanncode.data.database.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            "run.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(pokemonDatabase: PokemonDatabase) : PokemonDao{
        return pokemonDatabase.pokemonDao
    }
}