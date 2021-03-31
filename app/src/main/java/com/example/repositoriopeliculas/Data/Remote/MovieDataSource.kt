package com.example.repositoriopeliculas.Data.Remote

import com.example.repositoriopeliculas.Aplication.AppConstants
import com.example.repositoriopeliculas.Data.Model.MovieList
import com.example.repositoriopeliculas.Repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)

}