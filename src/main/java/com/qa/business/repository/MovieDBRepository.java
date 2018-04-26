package com.qa.business.repository;



import java.util.Collection;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

public class MovieDBRepository implements IMoviesRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);
	
		@PersistenceContext(unitName = "primary")
		private EntityManager manager;
		
		@Inject
		private JSONUtil util;
		
		public String getAllMovies() {
			
		LOGGER.info("MovieDBRepository getAllMovies");
		Query query = manager.createQuery("Select m FROM Movie m");
		Collection<Movie> movies =  query.getResultList();
		
		// TODO Auto-generated method stub
		return util.getJSONForObject(movies);
	}
		
		public String getAMovie(Long id) {
			Movie aMovie = getMovie(id);
			if(aMovie != null) {
				return util.getJSONForObject(aMovie);
			}
			else {
				return "{\"message\":\"movie not found\"}";
			}

		}

		private Movie getMovie(Long id) {
			return manager.find(Movie.class, id);
		}

		@Transactional(REQUIRED)
		public String createMovie(String movieJSON) {
			Movie aMovie = util.getObjectForJSON(movieJSON, Movie.class);
			manager.persist(aMovie);
			return "{\"message\":\"movie created\"}";
		}
		
		@Transactional(REQUIRED)
		public String deleteMovie(Long id) {
			Movie aMovie = getMovie(id);
			if(aMovie != null) {
				manager.remove(aMovie);
				return "{\"message\":\"movie deleted\"}";
			}
			else {
				return "{\"message\":\"movie not found\"}";
			}
		}

		}



