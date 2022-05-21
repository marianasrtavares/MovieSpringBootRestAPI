package com.marianatavares.challengexapand.utils;

import com.marianatavares.challengexapand.domain.Movie;
import com.marianatavares.challengexapand.dto.MovieDTO;

public class MovieMapper {
	

	public static Movie fromDto(MovieDTO movieDto) {
		Movie movie = new Movie(movieDto.getTitle(), movieDto.getLaunchDate(), movieDto.getRate(),
				movieDto.getRevenue());
		movie.setId(movieDto.getId());
		return movie;
	}

}
