package com.github.juanncode.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        PokemonEntity::class
    ],
    version = 1
)
abstract class PokemonDatabase : RoomDatabase(){
    abstract val pokemonDao: PokemonDao
}