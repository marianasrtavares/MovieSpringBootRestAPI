package com.marianatavares.challengexapand.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.dto.MovieDTO;
import com.marianatavares.challengexapand.repository.MovieRepository;
import com.marianatavares.challengexapand.utils.Validator;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository repo;
	
	public MovieServiceImpl (MovieRepository repo) {
		this.repo=repo;
	}

	public List<Movie> getAll() {
		return repo.findAll();
	}

	public Movie getByLaunchDate(String textDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate date;
		Movie movie;

		try {
			date = sdf.parse(textDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			movie = repo.findByLaunchDate(date);
			return movie;
		} catch (ParseException e) {
			return null;
		}

	}

	public Movie getById(Long id) {
		return repo.findById(id).get();
	}

	public void insertMovie(Movie movie) {
		Validator.validate(movie);
		repo.save(movie);
	}

	public void updateMovie(Movie movie, Long id) {

		Movie newMovie = repo.findById(id).get();
		if (movie.getTitle()!=null && newMovie.getTitle() != movie.getTitle()) {
			newMovie.setTitle(movie.getTitle());
		}
		if (movie.getLaunchDate()!=null &&newMovie.getLaunchDate() != movie.getLaunchDate()) {
			newMovie.setLaunchDate(movie.getLaunchDate());
		}
		if (movie.getRate()!=null &&newMovie.getRate() != movie.getRate()) {
			newMovie.setRate(movie.getRate());
		}

		if (movie.getRevenue()!=null && newMovie.getRevenue() != movie.getRevenue()) {
			newMovie.setRevenue(movie.getRevenue());
		}

	
		Validator.validate(newMovie);
		repo.save(newMovie);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}
	
	public Movie fromDto(MovieDTO movieDto) {
		Movie movie= new Movie(movieDto.getTitle(),movieDto.getLaunchDate(),movieDto.getRate(),movieDto.getRevenue());
	    movie.setId(movieDto.getId());
		return movie;
	}


}
