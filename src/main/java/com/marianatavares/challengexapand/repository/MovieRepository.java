package com.marianatavares.challengexapand.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marianatavares.challengexapand.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String>{

	public Movie findByLaunchDate(LocalDate launchDate);
	

	
	
	
}
