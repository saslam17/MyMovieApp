package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMoviesRepository;

public class MovieService implements IMovieService {
	
	@Inject
	private IMoviesRepository repo;
	
	public String getAllMovies() {
		
		return repo.getAllMovies();
	}

}
