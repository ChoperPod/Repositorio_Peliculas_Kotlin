package com.example.repositoriopeliculas.Repository

import com.example.repositoriopeliculas.Data.Model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}