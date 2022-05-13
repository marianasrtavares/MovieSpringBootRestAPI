package com.marianatavares.challengexapand.resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.service.MovieService;
import com.marianatavares.challengexapand.service.MovieServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private MovieService service;

	@InjectMocks
	private Movie movie1;
	private Movie movie2;
	List<Movie> movieList;

	@BeforeEach
	public void setUp() {
		this.service = mock(MovieServiceImpl.class);
		movieList = new ArrayList<>();
		movie1 = new Movie("Joker2", LocalDate.of(2021, 11, 1), 8, 293023.2);
		movie2 = new Movie("Windfall2", LocalDate.of(2021, 03, 11), 4, 8938293.2);
		movieList.addAll(Arrays.asList(movie1, movie2));

	}

	@AfterEach
	public void tearDown() {
		movie1 = movie2 = null;
		movieList = null;
	}

	@Test
	public void getAllMovies() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/movies").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getMoviesById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/movies/{id}", 1).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getMoviesByLaunchDate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/movies/{launchDate}", 1).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createMovieWhenPostMethod() throws Exception {
		ResultActions resultActions = mockMvc.perform(post("/movies").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(movie1)));

		resultActions.andExpect(status().isNoContent());
	}

	@Test
	public void updateMovieWhenPutMethod() throws Exception {
		when(service.getById(movie1.getId())).thenReturn(movie1);
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/movies/{id}", movie1.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(movie2));

		this.mockMvc.perform(builder).andExpect(status().isNoContent());
	}

	@Test
	public void deleteMoviesById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/movies/{id}", 1)).andExpect(status().isNoContent());

	}

}
