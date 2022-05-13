package com.marianatavares.challengexapand.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.marianatavares.challengexapand.domain.Movie;

public class MovieDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private LocalDate launchDate;
	private Integer rate;
	private Double revenue;
	
	public MovieDTO() {
		
	}
	
    public MovieDTO(Movie movie) {
    	id=movie.getId();
    	title=movie.getTitle();
    	launchDate=movie.getLaunchDate();
    	rate= movie.getRate();
    	revenue=movie.getRevenue();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
    
    
	
}
