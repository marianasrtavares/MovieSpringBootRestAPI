package com.marianatavares.challengexapand.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;

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
		repo.save(movie);
	}

	public void updateMovie(Movie movie, Long id) {

		Movie newMovie = repo.findById(id).get();

		if (movie.getTitle() != null && newMovie.getTitle() != movie.getTitle()) {
			newMovie.setTitle(movie.getTitle());
		}
		if (movie.getLaunchDate() != null && newMovie.getLaunchDate() != movie.getLaunchDate()) {
			newMovie.setLaunchDate(movie.getLaunchDate());
		}
		if (movie.getRate() != null && newMovie.getRate() != movie.getRate()) {
			newMovie.setRate(movie.getRate());
		}

		if (movie.getRevenue() != null && newMovie.getRevenue() != movie.getRevenue()) {
			newMovie.setRevenue(movie.getRevenue());
		}

		newMovie.setId(id);
		repo.save(newMovie);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}

}
