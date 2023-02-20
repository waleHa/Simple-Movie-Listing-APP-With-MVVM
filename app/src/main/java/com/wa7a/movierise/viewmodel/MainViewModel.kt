package com.wa7a.mvvmapp.data.viewmodel

import androidx.lifecycle.*
import com.wa7a.movierise.data.model.Movie
import com.wa7a.movierise.data.model.MovieResponse
import com.wa7a.movierise.data.model.State
import com.wa7a.movierise.ui.adapters.MovieInteractionListener
import com.wa7a.mvvmapp.data.repository.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel(),MovieInteractionListener {
    private val repository = MovieRepository()
    val popularMovies= repository.getMoviesList().asLiveData()

//    private var _movie = MutableLiveData<State<MovieResponse?>>()
//    val movie: LiveData<State<MovieResponse?>> = _movie


    init {
//        getMovieList()
    }

//    fun getMovieList() {
//        viewModelScope.launch {
//            repository.getMoviesList().collect{
//                _movie.postValue(it)
//            }
//            repository.getMoviesList().asLiveData()
//        }
//
//    }

    override fun onClickMovie(movie: Movie) {

    }
}