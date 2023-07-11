package com.example.themoviedb.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class TVResponse {
    @Parcelize
    class TelevisionResponse (
        @SerializedName("result")
        val Tv : List<TV>


    ): Parcelable {
        constructor(): this(mutableListOf())
    }

}
