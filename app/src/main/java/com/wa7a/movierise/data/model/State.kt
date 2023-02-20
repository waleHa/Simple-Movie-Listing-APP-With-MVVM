package com.wa7a.movierise.data.model

sealed class State<out T>{
    class Success<T>(val data:T?): State<T>()
    class Error(val message:String): State<Nothing>()
    object Loading: State<Nothing>()

    fun toData():T? = if(this is Success) data else null
}
