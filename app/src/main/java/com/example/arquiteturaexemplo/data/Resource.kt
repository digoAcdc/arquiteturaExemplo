package com.example.arquiteturaexemplo.data

sealed class Resource {
    data class Success<T>(val data: T? = null) : Resource()
    data class Failure<T>(val data: T? = null, val error: Throwable? = null) : Resource()
}

