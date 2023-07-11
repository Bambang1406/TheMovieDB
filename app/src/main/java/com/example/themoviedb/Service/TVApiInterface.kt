package com.example.themoviedb.Service

import com.example.themoviedb.Model.TVResponse
import retrofit2.Call
import retrofit2.http.GET

interface TVApiInterface {
    @GET("/3/TV/popular?_key=02eec283062277f2d88000fc9f2eaf41")
    fun getTVList(): Call<TVResponse>
}