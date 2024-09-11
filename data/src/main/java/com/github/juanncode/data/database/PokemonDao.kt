package com.github.juanncode.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemonentity")
    fun getPokemons(): Flow<List<PokemonEntity>>
    @Upsert
    suspend fun upsertPokemons(pokemons: List<PokemonEntity>)
}