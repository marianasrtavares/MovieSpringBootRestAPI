package com.marianatavares.challengexapand.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.marianatavares.challengexapand.domain.Movie;

public interface MovieResource {

	public ResponseEntity<List<Movie>> getAll();

	public ResponseEntity<Movie> getById(Long id);

	public ResponseEntity<Movie> getByLaunchDate(String textDate);

	public ResponseEntity<Void> insert(Movie movie);

	public ResponseEntity<Void> deleteById(Long id);

	public ResponseEntity<Void> updateMovie(Movie movie, @PathVariable Long id);

}
