package com.marianatavares.challengexapand.service;

import java.util.List;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.dto.MovieDTO;

public interface MovieService {

	public List<Movie> getAll();

	public Movie getByLaunchDate(String launchDate);

	public Movie getById(Long id);

	public void insertMovie(Movie movie);

	public void updateMovie(Movie movie, Long id);

	public void delete(Long id);
	
	public Movie fromDto(MovieDTO movieDto);
}
