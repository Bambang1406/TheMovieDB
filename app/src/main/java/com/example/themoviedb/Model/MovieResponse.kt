package com.example.themoviedb.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class MovieResponse{
    @Parcelize
    class MovieResponse (
        @SerializedName("result")
        val movies : List<Movie>


            ): Parcelable{
                constructor(): this(mutableListOf())
            }

}