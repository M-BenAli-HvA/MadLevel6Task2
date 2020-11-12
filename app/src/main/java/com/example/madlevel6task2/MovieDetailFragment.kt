package com.example.madlevel6task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.madlevel6task2.models.Movie
import kotlinx.android.synthetic.main.fragment_movie_detail.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailFragment : Fragment() {

    private val movieViewModel: MovieViewmodel by activityViewModels()
    private lateinit var movie: Movie

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie = movieViewModel.selectedMovie.value!!
        initView()
    }

    fun initView() {
      Glide.with(requireContext()).load(movie.getBackdropURL()).into(iv_movie_backdrop)
      Glide.with(requireContext()).load(movie.getPosterURL()).into(iv_movie_poster)
        tv_movie_title.text = movie.title
        tv_movie_date.text = movie.release_date
        tv_movie_ranking.text = movie.vote_average.toString()
        tv_movie_overview.text = movie.overview
    }

}