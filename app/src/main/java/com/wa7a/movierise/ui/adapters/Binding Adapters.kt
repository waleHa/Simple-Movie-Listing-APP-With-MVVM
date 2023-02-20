package com.wa7a.movierise.ui.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wa7a.movierise.BuildConfig
import com.wa7a.movierise.data.model.Movie
import com.wa7a.movierise.data.model.State

@BindingAdapter("imageSet")
fun ImageView.imageSetter(url: String) {
    val completeUrl= "${BuildConfig.imageBaseUrl}$url"
    Glide.with(this).load(completeUrl).centerCrop().into(this)
    Log.i("BindingAdapter", completeUrl)
}

@BindingAdapter("showWhenLoading")
fun <T> View.showWhenLoading(state: State<T>?) {
    if (state is State.Loading) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

@BindingAdapter("showWhenError")
fun <T> View.showWhenError(state: State<T>?) {
    if (state is State.Error) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

@BindingAdapter("showWhenSuccess")
fun <T> View.showWhenSuccess(state: State<T>?) {
    if (state is State.Success) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

@BindingAdapter("setItems")
fun <T>RecyclerView.setRecyclerItems(items: List<T>?) {
    if (items != null) {
        (this.adapter as BaseAdapter<T>?)?.setItems(items)
    }else{
        (this.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}