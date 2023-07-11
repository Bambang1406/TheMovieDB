package com.example.themoviedb.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class TV {
    @Parcelize
    data class Tv(
        @SerializedName("id")
        val id: String?,

        @SerializedName("title")
        val title: String?,

        @SerializedName("poster_path")
        val poster: String?,

        @SerializedName("overview")
        val overview: String?,

        ) : Parcelable {
        constructor() : this("", "", "", "")
    }
}
