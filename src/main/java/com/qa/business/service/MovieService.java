package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMoviesRepository;

public class MovieService implements IMovieService {
	
	@Inject
	private IMoviesRepository repo;
	
	public String getAllMovies() {
		
		return repo.getAllMovies();
	}

	@Override
	public String getAMovie(Long id) {
		return repo.getAMovie(id);
	}

	@Override
	public String createMovie(String jsonMovie) {
		return repo.createMovie(jsonMovie);
	}
	
	@Override
	public String deleteMovie(Long id) {
		return repo.deleteMovie(id);
	}

}

