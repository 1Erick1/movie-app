package com.example.interviewexercise.views.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.databinding.ItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val items = mutableListOf<Movie>()
    var onMovieSelected: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onMovieSelected
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(list: List<Movie>){
        items.addAll(list)
        notifyItemRangeChanged(0,list.size)
    }
}
