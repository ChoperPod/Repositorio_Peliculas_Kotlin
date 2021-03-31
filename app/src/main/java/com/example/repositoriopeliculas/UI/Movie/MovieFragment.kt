package com.example.repositoriopeliculas.UI.Movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.repositoriopeliculas.Core.Resource
import com.example.repositoriopeliculas.Data.Remote.MovieDataSource
import com.example.repositoriopeliculas.Presentation.MovieViewModel
import com.example.repositoriopeliculas.Presentation.MovieViewModelFactory
import com.example.repositoriopeliculas.R
import com.example.repositoriopeliculas.Repository.MovieRepositoryImpl
import com.example.repositoriopeliculas.Repository.RetrofitClient
import com.example.repositoriopeliculas.databinding.FragmentMovieBinding
import kotlin.math.log

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {MovieViewModelFactory(MovieRepositoryImpl(
        MovieDataSource(RetrofitClient.webservice)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        viewModel.fetchUpcomingMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading...")
                }
                is Resource.Success -> {
                    Log.d("LiveData", "${result.data}")
                }
                is Resource.Failure -> {
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }
}