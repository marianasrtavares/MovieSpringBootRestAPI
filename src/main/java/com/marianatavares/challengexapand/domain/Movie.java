package com.marianatavares.challengexapand.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="movie")
public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")	
	@Column(name="id")
	private String id;
	@Column(name="title")
	private String title;

	@Column(name="launchdate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate launchDate;
	@Column(name="rate")
	private Integer rate;
	@Column(name="revenue")
	private Double revenue; 

	public Movie() {
		
	}

	public Movie(String title, LocalDate launchDate, Integer rate, Double revenue) {
		this.title = title;
		this.launchDate = launchDate;
		this.rate = rate;
		this.revenue = revenue;
	}

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id=id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getLaunchDate() {
		return this.launchDate;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", launchDate=" + launchDate + ", rank=" + rate + ", revenue="
				+ revenue + "]";
	}
	
	
	
	
	
	
}
