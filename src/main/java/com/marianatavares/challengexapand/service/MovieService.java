package com.marianatavares.challengexapand.service;

import java.time.LocalDate;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;

	public List<Movie> getAll() {
		return repo.findAll();
	}

	public Movie getByLaunchDate(LocalDate launchDate) {
		return repo.findByLaunchDate(launchDate);
	}

	public Movie getById(String id) {
		return repo.findById(id).get();
	}

	public void insertMovie(Movie movie) {
		repo.save(movie);
	}

	public void updateMovie(Movie movie) {
		repo.save(movie);
	}

	public void delete(String id) {
		repo.deleteById(id);

	}

}
