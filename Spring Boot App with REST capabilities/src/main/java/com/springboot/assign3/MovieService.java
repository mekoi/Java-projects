package com.springboot.assign3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	Map<Integer, Movie> movie = new HashMap<>();

    public void addMovie(Movie mov) throws Exception {
        if(movie.containsKey(mov.getMovieId())) {
            throw new Exception("This Movie Id already exists");
        }
        else {
        	movie.put(mov.getMovieId(), mov);
        }
    }

    public Iterable<Movie> getMovies(){
        return movie.values();
    }

    public Movie getMovie(int movId) throws Exception {

        if(movie.containsKey(movId)) {
            return movie.get(movId);
        }
        else {
            throw new Exception("Movie Id not found");
        }
    }

    public void updateMovie(Movie mov) throws Exception {
        if(movie.containsKey(mov.getMovieId())) {
        	movie.put(mov.getMovieId(), mov);
        }
        else {
            throw new Exception("Movie Id not found");
        }
    }

    public void deleteMovie(int movId) throws Exception {
        if(movie.containsKey(movId)) {
        	movie.remove(movId);
        }
        else {
            throw new Exception("Movie Id not found");
        }
    }
}
