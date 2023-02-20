package com.wa7a.mvvmapp.data.repository

import android.provider.SyncStateContract.Constants
import com.wa7a.movierise.data.model.State
import com.wa7a.mvvmapp.data.network.RetrofitBuilder
import com.wa7a.utils.Constants.key
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepository {
    fun getMoviesList() = wrapWithFlow{ RetrofitBuilder.api.getMovieList(key) }

    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error("ERROR IS: 2: ${result.message()}"))
                }
            } catch (e: Exception) {
                emit(State.Error("ERROR IS: 1: ${e.message.toString()}"))
            }
        }
    }
}