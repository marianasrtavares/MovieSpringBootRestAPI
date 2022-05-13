package com.marianatavares.challengexapand.utils;

import com.marianatavares.challengexapand.domain.Movie;

public class Validator {
	
	public static void validate(Movie movie) {
		
		if(movie.getTitle()==null) throw new IllegalArgumentException("Movie title cannot be null");
		if(movie.getLaunchDate()==null) throw new IllegalArgumentException("Movie launchdate cannot be null");
		if(movie.getRate()==null) throw new IllegalArgumentException("Movie rate cannot be null");
		if(movie.getRevenue()==null) throw new IllegalArgumentException("Movie revenue cannot be null");

		
	}

}
