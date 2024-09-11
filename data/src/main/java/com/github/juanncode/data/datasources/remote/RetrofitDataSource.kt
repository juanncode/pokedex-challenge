package com.github.juanncode.data.datasources.remote

import com.github.juanncode.data.mappers.toDomain
import com.github.juanncode.data.retrofit.ApiService
import com.github.juanncode.data.util.safeApiCall
import com.github.juanncode.domain.Pokemon
import com.github.juanncode.domain.utils.Resource
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val apiService: ApiService
): RemoteDataSource {
    override suspend fun fetchPokemons(): Resource<List<Pokemon>> {
        return safeApiCall {
            apiService.fetchPokemons().results.map { it.toDomain() }
        }
    }
}