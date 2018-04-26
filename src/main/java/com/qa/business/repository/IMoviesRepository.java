package com.qa.business.repository;

public interface IMoviesRepository {
	String getAllMovies();
	
	String getAMovie(Long id);
	String createMovie(String movieJSON);

	String deleteMovie(Long id);

}

