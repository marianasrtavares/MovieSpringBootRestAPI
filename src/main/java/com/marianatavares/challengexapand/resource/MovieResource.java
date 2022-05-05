package com.marianatavares.challengexapand.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findAll() {
		List<Movie> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Movie> findById(@PathVariable String id) {
		Movie movie = service.findById(id);
		return ResponseEntity.ok().body(movie);
	}

	@RequestMapping(value = "/datesearch", method = RequestMethod.GET)
	public ResponseEntity<Movie> findByLaunchDate(
			// @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate
			@RequestParam String textDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate date;
		Movie movie;
		try {
			date = sdf.parse(textDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			movie = service.findByLaunchDate(date);
			return ResponseEntity.ok().body(movie);

		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Movie movie) {
		service.insertMovie(movie);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException ex) {
			System.out.println(ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMovie(@RequestBody Movie movie, @PathVariable String id) {

		try {
			Movie newMovie = service.findById(id);

			if (newMovie == null) {
				return ResponseEntity.notFound().build();
			}

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
			service.insertMovie(newMovie);
			return ResponseEntity.noContent().build();

		} catch (NoSuchElementException ex) {
			System.out.println(ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
