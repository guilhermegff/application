package com.example.datasource_api

sealed interface LocalDataSourceResult {
    object Error : LocalDataSourceResult
    object NotFound : LocalDataSourceResult
    data class Result<T> (val value: T) : LocalDataSourceResult
}