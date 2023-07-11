package com.example.themoviedb.Service

import com.example.themoviedb.Model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/Movie/popular?_key=02eec283062277f2d88000fc9f2eaf41")
    fun getMovieList(): Call<MovieResponse>
}