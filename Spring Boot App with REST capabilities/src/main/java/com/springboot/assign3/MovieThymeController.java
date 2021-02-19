package com.springboot.assign3;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieThymeController {
	
   //private static List movieList = new ArrayList();
	private static List<Movie> movieList = new ArrayList<Movie>();
    
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }   

    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public ModelAndView saveMovie(@ModelAttribute Movie movie)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("moviedetail");
        movieList.add(movie);
        mv.addObject("movieList", movieList);
        return mv;
    }      
}
