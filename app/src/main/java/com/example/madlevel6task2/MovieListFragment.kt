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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task2.adapters.MoviesAdapter
import com.example.madlevel6task2.models.Movie
import kotlinx.android.synthetic.main.fragment_movie_list.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@RequiresApi(Build.VERSION_CODES.N)
class MovieListFragment : Fragment() {

    private val movies: ArrayList<Movie> = arrayListOf(
//        Movie("/ld7V9BjMk2xtiBNcR8savyyk5ca.jpg",
//            "/tzYkC0vqX8Dokuwynhz1lnWWgWT.jpg",
//            "Miss Peregrine's Home for Peculiar Children",
//            SimpleDateFormat("dd-MM-yyyy").parse("2016-09-28"),
//            6.7,
//            "A teenager finds himself transported to an island where he must help protect a group of orphans with special powers from creatures intent on destroying them."
//        ),
//        Movie("/ld7V9BjMk2xtiBNcR8savyyk5ca.jpg",
//            "/tzYkC0vqX8Dokuwynhz1lnWWgWT.jpg",
//            "Miss Peregrine's Home for Peculiar Children",
//            SimpleDateFormat("dd-MM-yyyy").parse("2016-09-28"),
//            6.7,
//            "A teenager finds himself transported to an island where he must help protect a group of orphans with special powers from creatures intent on destroying them."
//        )
    )

    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesAdapter = MoviesAdapter(movies, ::onClick)

                rv_movies.layoutManager = GridLayoutManager(activity,
            2)
        rv_movies.adapter = moviesAdapter
    }

    fun initViews() {

    }

    fun onClick(movie: Movie) {

    }
}