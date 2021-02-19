package com.springboot.assign3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController { 
	
	@Autowired
    MovieService movieService;
	
	@ResponseBody
	@RequestMapping("")
	public String home()
	{
		return "Create a Movie Web service";
	}

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    Movie getMovie(@PathVariable("movieId") int movId) throws Exception {
        return movieService.getMovie(movId);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    Iterable<Movie> getMovies() {
        return movieService.getMovies();
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addMovie(@RequestBody Movie mov) throws Exception {
    	movieService.addMovie(mov);
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateMovie(@PathVariable("movieId") int movId, @RequestBody Movie mov) throws Exception {
    	mov.setMovieId(movId);
    	movieService.updateMovie(mov);
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteMovie(@PathVariable("movieId") int movId) throws Exception {
    	movieService.deleteMovie(movId);
    }
	
}