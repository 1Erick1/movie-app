package com.example.interviewexercise.views.gallery

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewexercise.data.Movie

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val items = mutableListOf<Movie>()
    var onMovieSelected: ((Long) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
