package com.github.juanncode.data.util

import com.github.juanncode.domain.utils.ErrorGeneric
import com.github.juanncode.domain.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher = Dispatchers.IO, apiCall: suspend () -> T): Resource<T> {

    return withContext(dispatcher) {
        try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            Resource.Error(throwable.toError())
        }
    }
}

fun Throwable.toError(): ErrorGeneric = when (this) {
    is IOException -> ErrorGeneric(
        code = 0,
        message = "Tuvimos un problema de conectividad, por favor revise su conexión a internet y vuelva a intentarlo",
        error = stackTraceToString()
    )
    is HttpException -> ErrorGeneric(
        code = code(),
        message = message,
        error = stackTraceToString()
    )
    else -> ErrorGeneric(code = 0, message = message ?: "", error = stackTraceToString())
}