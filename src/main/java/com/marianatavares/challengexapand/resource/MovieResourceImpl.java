package com.marianatavares.challengexapand.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.dto.MovieDTO;
import com.marianatavares.challengexapand.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResourceImpl implements MovieResource {

	private final MovieService service;

	public MovieResourceImpl(MovieService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MovieDTO>> getAll() {
		List<Movie> list = service.getAll();
		List<MovieDTO> listDto = list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
		Movie movie = service.getById(id);
		MovieDTO movieDto = new MovieDTO(movie);
		return ResponseEntity.ok().body(movieDto);
	}

	@RequestMapping(value = "/datesearch", method = RequestMethod.GET)
	public ResponseEntity<MovieDTO> getByLaunchDate(@RequestParam String textDate) {
		Movie movie = service.getByLaunchDate(textDate);
		MovieDTO movieDto = new MovieDTO(movie);
		return ResponseEntity.ok().body(movieDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MovieDTO movieDto) {
		Movie movie = service.fromDto(movieDto);
		service.insertMovie(movie);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMovie(@RequestBody MovieDTO movieDto, @PathVariable Long id) {
		Movie movie = service.fromDto(movieDto);
		service.updateMovie(movie, id);
		return ResponseEntity.noContent().build();
	}

}
