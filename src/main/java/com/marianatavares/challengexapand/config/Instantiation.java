package com.marianatavares.challengexapand.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.repository.MovieRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private MovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		repo.deleteAll();

		Movie movieAvengers = new Movie("Avengers", LocalDate.of(2022, 11, 16), 1, 173822.938);
		Movie movieDune = new Movie("Dune", LocalDate.of(2021, 05, 06), 2, 8437322.938);
		Movie movieWindfall = new Movie("Windfall", LocalDate.of(2022, 01, 26), 3, 25645842.938);
		Movie movieUnforgivable = new Movie("The Unforgivable", LocalDate.of(2021, 12, 9), 4, 6538349.938);
		Movie movieDance = new Movie("Dance", LocalDate.of(2021, 03, 30), 5, 928372.938);
		Movie movieOzark = new Movie("Ozark", LocalDate.of(2022, 07, 06), 6, 45826374.938);

		repo.saveAll(Arrays.asList(movieAvengers, movieDune, movieWindfall, movieUnforgivable, movieDance, movieOzark));
	}

}
