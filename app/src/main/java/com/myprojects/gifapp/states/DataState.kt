package com.myprojects.gifapp.states

sealed class DataState<out T> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Failure(val error: String) : DataState<Nothing>()
    object EmptyResult : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
