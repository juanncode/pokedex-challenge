package com.github.juanncode.domain.utils

sealed class Resource<out T> {
    data class Success<T>(val value: T): Resource<T>()
    data class Error(val error: ErrorGeneric? = null) : Resource<Nothing>()
}