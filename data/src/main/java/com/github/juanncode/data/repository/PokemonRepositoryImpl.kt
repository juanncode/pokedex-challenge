package com.github.juanncode.data.repository

import com.github.juanncode.data.datasources.local.LocalDataSource
import com.github.juanncode.data.datasources.remote.RemoteDataSource
import com.github.juanncode.domain.Pokemon
import com.github.juanncode.domain.repository.PokemonRepository
import com.github.juanncode.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): PokemonRepository {
    override fun getPokemons(): Flow<List<Pokemon>> {
        return localDataSource.getPokemons()
    }

    override suspend fun fetchPokemons(): Resource<Unit> {

        val response = remoteDataSource.fetchPokemons()
        return when(response){
            is Resource.Error -> Resource.Error(response.error)
            is Resource.Success -> {
                localDataSource.upsertPokemon(response.value)
                Resource.Success(Unit)
            }
        }

    }

}