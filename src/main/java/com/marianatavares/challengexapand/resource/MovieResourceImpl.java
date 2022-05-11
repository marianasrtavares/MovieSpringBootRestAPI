package com.marianatavares.challengexapand.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MovieResourceImpl implements MovieResource {

	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> getAll() {
		List<Movie> list = service.getAll();
		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Movie> getById(@PathVariable Long id) {
		Movie movie = service.getById(id);
		return ResponseEntity.ok().body(movie);
	}

	@RequestMapping(value = "/datesearch", method = RequestMethod.GET)
	public ResponseEntity<Movie> getByLaunchDate(@RequestParam String textDate) {
		Movie movie = service.getByLaunchDate(textDate);
		return ResponseEntity.ok().body(movie);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Movie movie) {
		service.insertMovie(movie);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
			service.updateMovie(movie,id);
			return ResponseEntity.noContent().build();
	}

}
