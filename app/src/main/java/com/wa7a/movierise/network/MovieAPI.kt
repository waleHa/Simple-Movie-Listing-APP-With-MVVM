package com.wa7a.mvvmapp.data.network

import com.wa7a.movierise.data.model.MovieResponse
import com.wa7a.utils.Constants.key
import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.internal.NopCollector.emit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieAPI {
//    @GET("movie/{movie_id}")
//    suspend fun getAMovie(@Path("modie_id") movie_id: Int): Response<MovieResponse>

    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") api_key: String,
//        @Query("language") language: String = "US"
    ): Response<MovieResponse>
}

