package com.example.interviewexercise.views.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.interviewexercise.data.PopularMoviesResponse
import com.example.interviewexercise.networking.common.Resource
import com.example.interviewexercise.repository.MovieRepository

class GalleryViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val moviesLiveData: MutableLiveData<Resource<PopularMoviesResponse>> = MutableLiveData()

}
