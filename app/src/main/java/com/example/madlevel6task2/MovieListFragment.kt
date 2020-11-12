package com.example.madlevel6task2

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task2.adapters.MoviesAdapter
import com.example.madlevel6task2.models.Movie
import com.example.madlevel6task2.repository.MovieRepository
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@RequiresApi(Build.VERSION_CODES.N)
class MovieListFragment : Fragment() {

    private lateinit var navController: NavController
    private val movies: ArrayList<Movie> = arrayListOf()

    private lateinit var moviesAdapter: MoviesAdapter
    private val moviesViewmodel: MovieViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        moviesAdapter = MoviesAdapter(movies, ::onClick)

        rv_movies.layoutManager = GridLayoutManager(
            activity,
            2
        )
        rv_movies.adapter = moviesAdapter

        initViews()
        observeMovies()
    }

    fun observeMovies() {
        moviesViewmodel.movies.observe(viewLifecycleOwner, Observer {
            movies.clear()
            movies.addAll(it)
            moviesAdapter.notifyDataSetChanged()
        })
    }

    fun submit() {
        val year = etYear.text.toString().toInt()
        moviesViewmodel.getMoviesByYear(year)
    }

    fun initViews() {
        btn_submit.setOnClickListener {
            submit()
        }
    }
    fun onClick(movie: Movie) {
        println(movie.title)
        moviesViewmodel.setSelectedMovie(movie)
        navController.navigate(R.id.action_MovieListFragment_to_MovieDetailFragment)
    }
}
