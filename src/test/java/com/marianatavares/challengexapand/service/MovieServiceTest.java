package com.marianatavares.challengexapand.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.repository.MovieRepository;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
	
	@Mock
	private MovieRepository repo;
	
	@InjectMocks 
	private MovieService service;
	
	@Test
	public void shouldReturnAllMovies() {
		List<Movie> movies= new ArrayList();
		movies.add(new Movie());
		
		
	}
	

}
