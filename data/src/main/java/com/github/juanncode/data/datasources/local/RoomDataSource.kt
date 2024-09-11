package com.github.juanncode.data.datasources.local

import com.github.juanncode.data.database.PokemonDao
import com.github.juanncode.data.mappers.toDomain
import com.github.juanncode.data.mappers.toEntity
import com.github.juanncode.domain.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomDataSource @Inject constructor(
    private val pokemonDao: PokemonDao
) : LocalDataSource {
    override fun getPokemons(): Flow<List<Pokemon>> {
        return pokemonDao.getPokemons().map {
            it.map { pokemonEntity ->
                pokemonEntity.toDomain()
            }
        }
    }

    override suspend fun upsertPokemon(pokemons: List<Pokemon>) {
        val entities = pokemons.map {
            it.toEntity()
        }
        pokemonDao.upsertPokemons(entities)
    }
}