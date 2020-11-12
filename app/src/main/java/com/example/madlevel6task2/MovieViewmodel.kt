package com.example.madlevel6task2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.api.MoviesApi
import com.example.madlevel6task2.models.Movie
import com.example.madlevel6task2.repository.MovieRepository
import com.example.madlevel6task2.services.MoviesApiService
import kotlinx.coroutines.launch
import java.util.*

class MovieViewmodel(application: Application) : AndroidViewModel(application) {
    private val TAG = "MovieViewModel"
    private val movieRepository: MovieRepository = MovieRepository()
    private val moviesApiService: MoviesApiService = MoviesApi.createAPI()

    val selectedMovie: MutableLiveData<Movie> = MutableLiveData()
    val movies: LiveData<List<Movie>> = movieRepository.movies

    fun getMoviesByYear(year: Int) {
        viewModelScope.launch {
            try {
                movieRepository.getMoviesByYear(year)
            } catch(error: Throwable) {
                Log.e(TAG, error.message!!)
            }
        }
    }

    fun setSelectedMovie(movie: Movie) {
        viewModelScope.launch {
            try {
                selectedMovie.value = movie
            } catch(error: Throwable) {
                Log.e(TAG, error.message!!)
            }
        }
    }
}