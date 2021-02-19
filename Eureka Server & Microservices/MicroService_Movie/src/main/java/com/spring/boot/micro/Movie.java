package com.spring.boot.micro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="movie")
public class Movie {
	
	@NotNull 
	@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="movieid")
	private int movieId;
	
	@NotNull(message="Move name is needed")
	@Size(min=1, max=100)
	@Column(name="moviename")
	private String movieName;	
	
	@NotNull(message="A language is needed for the movie")
	@Size(min=1, max=20)
	@Column(name="movielanguage")
	private String movieLanguage;
	
	@NotNull(message="A genre is needed for the movie")
	@Size(min=1, max=20)
	@Column(name="moviegenre")
	private String movieGenre;
	
	@NotNull(message="A duration is needed for the movie")
	@Min(value=5)
	@Max(value=150)
	@Column(name="duration")
	private int duration;	
	
	public Movie() {		
	}

	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}	
}