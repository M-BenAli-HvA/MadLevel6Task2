package com.example.madlevel6task2.services

import com.example.madlevel6task2.BuildConfig
import com.example.madlevel6task2.models.MoviesList
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {



   @GET("discover/movie?api_key=${BuildConfig.API_KEY}&language=en-US")
   suspend fun getMoviesByYear(@Query("year") year: Int,
                                @Query("sort") sort: String? = "popularity.desc")
    : MoviesList
}