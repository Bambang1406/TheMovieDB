package com.example.themoviedb.Model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class Movie {
    @Parcelize
    data class Movie (
        @SerializedName("id")
        val id : String?,

        @SerializedName("title")
        val title : String?,

        @SerializedName("poster_path")
        val poster : String?,

        @SerializedName("overview")
        val overview : String?,

        ) : Parcelable{
            constructor(): this("","","","")
        }
}