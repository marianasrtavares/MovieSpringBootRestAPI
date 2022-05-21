package com.marianatavares.challengexapand.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.dto.MovieDTO;
import com.marianatavares.challengexapand.repository.MovieRepository;
import com.marianatavares.challengexapand.utils.MovieMapper;
import com.marianatavares.challengexapand.utils.Validator;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository repo;

	public MovieServiceImpl(MovieRepository repo) {
		this.repo = repo;
	}

	public List<Movie> getAll() {
		return repo.findAll();
	}

	public Movie getByLaunchDate(LocalDate date) {
		Movie movie = repo.findByLaunchDate(date);
		return movie;
	}

	public Movie getById(Long id) {
		return repo.findById(id).get();
	}

	public void insertMovie(MovieDTO movieDto) {
		Validator.validate(movieDto);
		Movie movie = MovieMapper.fromDto(movieDto);
		repo.save(movie);
	}

	public void updateMovie(MovieDTO movieDto, Long id) {
		Validator.validate(movieDto);
		Movie movie = MovieMapper.fromDto(movieDto);
		movie.setId(id);
		repo.save(movie);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}

}
