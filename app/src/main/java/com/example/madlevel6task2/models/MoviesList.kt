package com.example.madlevel6task2.models

import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("results") val results : List<Movie>
)
