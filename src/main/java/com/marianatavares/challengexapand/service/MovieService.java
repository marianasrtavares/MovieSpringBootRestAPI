package com.marianatavares.challengexapand.service;

import java.time.LocalDate;
import java.util.List;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.dto.MovieDTO;

public interface MovieService {

	public List<Movie> getAll();

	public Movie getByLaunchDate(LocalDate launchDate);

	public Movie getById(Long id);

	public void insertMovie(MovieDTO movieDto);

	public void updateMovie(MovieDTO movieDto, Long id);

	public void delete(Long id);

}
