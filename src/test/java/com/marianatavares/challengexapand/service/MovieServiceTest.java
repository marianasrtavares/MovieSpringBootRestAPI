package com.marianatavares.challengexapand.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
	
	
	@Mock
	private MovieRepository repo;
	
	@Autowired
	@InjectMocks 
	private MovieService service;
	private Movie movie1;
	private Movie movie2;
	List<Movie> movieList;
	
	@BeforeEach
	public void setUp() {
		movieList= new ArrayList<>();
		movie1= new Movie("Joker2", LocalDate.of(2021, 11, 1), 8,293023.2);
		movie2=new Movie("Windfall2", LocalDate.of(2021, 03, 11), 4, 8938293.2);
		movieList.addAll(Arrays.asList(movie1,movie2));

	}
	
	@AfterEach
	public void tearDown() {
		movie1=movie2=null;
		movieList=null;
	}
	
	@Test
	public void shouldReturnAllMovies() {
		when(repo.findAll()).thenReturn(movieList);
		List<Movie>movieList1=service.getAll();
		assertEquals(movieList, movieList1);
		
	}
	
	@Test
	public void whenGivenLaunchDateShouldReturnMovieWithThatLaunchDate() {
		when(repo.findByLaunchDate(LocalDate.of(2021, 11, 1))).thenReturn((movie1));
		assertThat(service.getByLaunchDate(LocalDate.of(2021, 11, 1))).isEqualTo(movie1);
	}
	
	@Test
	public void whenGivenMovieToAddShouldSaveTheMovie() {
		when(repo.save(movie1)).thenReturn(movie1);
		service.insertMovie(movie1);
		verify(repo, times(1)).save(movie1);
	}
	
	@Test
	public void whenGivenMovieShouldUpdateMovieFound() {
		movie1.setTitle("Joker3");
	    service.updateMovie(movie1);
	    verify(repo).save(movie1);
	}
	
	@Test
	public void whenGivenIdToDeleteShouldDeleteTheMovie() {
		service.delete(movie1.getId());
		verify(repo).deleteById(movie1.getId());
				
	
	}
	

}
