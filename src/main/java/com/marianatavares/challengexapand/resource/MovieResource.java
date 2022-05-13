package com.marianatavares.challengexapand.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.marianatavares.challengexapand.dto.MovieDTO;

public interface MovieResource {

	public ResponseEntity<List<MovieDTO>> getAll();

	public ResponseEntity<MovieDTO> getById(Long id);

	public ResponseEntity<MovieDTO> getByLaunchDate(String textDate);

	public ResponseEntity<Void> insert(MovieDTO movieDto);

	public ResponseEntity<Void> deleteById(Long id);

	public ResponseEntity<Void> updateMovie(MovieDTO movieDto, @PathVariable Long id);

}
