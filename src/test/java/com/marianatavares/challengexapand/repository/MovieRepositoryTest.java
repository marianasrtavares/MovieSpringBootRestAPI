package com.marianatavares.challengexapand.repository;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.marianatavares.challengexapand.domain.Movie;

@DataJpaTest
@AutoConfigureTestDatabase (replace=AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTest {
	
	@Autowired
	private MovieRepository repo;
	
	@Test
	public void getEmployeeTestByLaunchDate() {
		
		Movie expectedMovie= new Movie();
		expectedMovie.setTitle("Belfast");
		expectedMovie.setLaunchDate(LocalDate.of(2022,02,24));
		expectedMovie.setRate(1);
		expectedMovie.setRevenue(38293438.0);
		
		Movie savedMovie= repo.save(expectedMovie);
		
		Movie actual= repo.findByLaunchDate(savedMovie.getLaunchDate());
		
		
		Assertions.assertThat(actual).isEqualTo(expectedMovie);
	}

}
