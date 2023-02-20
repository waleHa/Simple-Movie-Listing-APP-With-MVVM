package com.wa7a.movierise.ui.adapters

import com.wa7a.movierise.R
import com.wa7a.movierise.data.model.Movie

class MovieAdapter(items: List<Movie>, private val listener: MovieInteractionListener,
                   override val layoutId: Int = R.layout.movie_item
) :
    BaseAdapter<Movie>(items, listener) {
}

interface MovieInteractionListener : BaseInteractionListener {
    fun onClickMovie(movie: Movie)
}


