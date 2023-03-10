package com.example.interviewexercise.networking.apis

import com.example.interviewexercise.data.GenericErrorResponse
import com.example.interviewexercise.data.PopularMoviesResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMoviesAsync(): NetworkResponse<PopularMoviesResponse, GenericErrorResponse>
}
