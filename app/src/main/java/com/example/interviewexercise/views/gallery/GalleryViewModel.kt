package com.example.interviewexercise.views.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewexercise.data.PopularMoviesResponse
import com.example.interviewexercise.networking.common.Resource
import com.example.interviewexercise.repository.MovieRepository
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.launch

class GalleryViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _moviesLiveData: MutableLiveData<Resource<PopularMoviesResponse>> = MutableLiveData()
    val moviesLiveData: LiveData<Resource<PopularMoviesResponse>> = _moviesLiveData

    fun getMovies(page: Int=0){
        viewModelScope.launch {
            _moviesLiveData.value = Resource.loading()
            when (val response = movieRepository.getPopularMovies(page)){
                is NetworkResponse.Success -> {
                    _moviesLiveData.value = Resource.success(response.body)
                }
                is NetworkResponse.ServerError -> {
                    _moviesLiveData.value = Resource.error(response.body?.message,null, response.body?.statusCode)
                }
                is NetworkResponse.NetworkError -> {
                    _moviesLiveData.value = Resource.error(response.error.message, null, null)
                }
                is NetworkResponse.UnknownError -> {
                    _moviesLiveData.value = Resource.exception(null,response.error)
                }
            }
        }
    }

}
