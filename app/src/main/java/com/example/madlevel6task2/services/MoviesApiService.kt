package com.example.madlevel6task2.services

import com.example.madlevel6task2.models.MoviesList
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

   @GET("discover/movie?api_key=1aedca454e9de96637badb619d147f7c")
   suspend fun getMoviesByYear(@Query("year") year: Int,
                                @Query("sort") sort: String? = "popularity.desc")
    : MoviesList
}