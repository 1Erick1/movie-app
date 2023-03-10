package com.example.interviewexercise.views.gallery

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.databinding.ItemMovieBinding
import com.example.interviewexercise.views.util.buildPosterUrl
import com.example.interviewexercise.views.util.load

class MovieViewHolder(
    private val view: ItemMovieBinding,
    private val onItemClicked: ((Movie) -> Unit)?,
) : RecyclerView.ViewHolder(view.root) {

    fun bind(movie: Movie) {
        with(view){
            ivPoster.load(buildPosterUrl(movie.posterPath))
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            ivStar.visibility = if (movie.voteAverage!=null && movie.voteAverage >8.0) View.VISIBLE else View.GONE
            itemView.setOnClickListener { onItemClicked?.invoke(movie) }
        }
    }

}
