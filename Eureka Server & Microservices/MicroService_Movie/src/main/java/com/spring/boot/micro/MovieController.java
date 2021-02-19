package com.spring.boot.micro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

	@Autowired 
	private MovieRepository movieRepository;
	
	@RequestMapping("/")
    public String show(Model model)
    {
        model.addAttribute("movies", movieRepository.findAll());
        return "show";
    }			
			
	//To get the add-movie
	@GetMapping("/add")
	public String add(Movie movie)
	{
		return "add-movie";
	}			
	
	@PostMapping("/add")
    public String add(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }

        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "show";
    }
	
	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    Movie mov = movieRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid movie number:" + no));

	    model.addAttribute("movie", mov);
	    return "update-movie";
	}
	
	//update the existing movie info
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid Movie movie,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	movie.setMovieId(no);
	        return "update-movie";
	    }
	    movieRepository.save(movie);
	    model.addAttribute("movies", movieRepository.findAll());
	    return "show";
	}
	
	
	//delete a movie info
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
	    Movie mov= movieRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid movie Number:" + no));
	    movieRepository.delete(mov);
	    model.addAttribute("movies", movieRepository.findAll());
	    return "show";
	}    
}