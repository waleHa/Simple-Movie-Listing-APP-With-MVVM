package com.wa7a.movierise.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.movierise.R
import com.wa7a.movierise.data.model.Movie
import com.wa7a.movierise.databinding.MovieItemBinding

class MovieAdapter(private var items: List<Movie>, private val listener: MovieInteractionListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = items.get(position)
        holder.binding.item = currentItem
        holder.binding.listener = listener
    }

    override fun getItemCount(): Int = requireNotNull(items.size)

    fun setItems(newItems: List<Movie>) {
        items = newItems
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = MovieItemBinding.bind(itemView)
    }
}

interface MovieInteractionListener {
    fun onClickMovie(movie: Movie)
}
