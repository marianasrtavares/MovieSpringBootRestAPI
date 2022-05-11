package com.marianatavares.challengexapand.service;

import java.util.List;

import com.marianatavares.challengexapand.domain.Movie;

public interface MovieService {

	public List<Movie> getAll();

	public Movie getByLaunchDate(String launchDate);

	public Movie getById(Long id);

	public void insertMovie(Movie movie);

	public void updateMovie(Movie movie, Long id);

	public void delete(Long id);
}
