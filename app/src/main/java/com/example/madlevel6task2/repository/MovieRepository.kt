package com.example.madlevel6task2.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.api.MoviesApi
import com.example.madlevel6task2.models.Movie
import com.example.madlevel6task2.models.MoviesList
import com.example.madlevel6task2.services.MoviesApiService
import kotlinx.coroutines.withTimeout

class MovieRepository {

    private val TAG = "Repository"
    private val moviesApiService: MoviesApiService = MoviesApi.createAPI()
    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movies: LiveData<List<Movie>>
        get() = _movies

   suspend fun getMoviesByYear(year: Int) {
        try  {
            val result = withTimeout(5_000) {
                moviesApiService.getMoviesByYear(year)
            }
            Log.d(TAG, result.results.size.toString())
            _movies.value = result.results
        } catch(error: Throwable) {

        }

    }

}