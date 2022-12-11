package com.microservice.movieinfoservices;

import com.microservice.movieinfoservices.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieResources {
    
    @Autowired
    MovieService movieService;
    
    @RequestMapping("/hello")
    public String sayHi(){
        return("Hey");
    }

    @RequestMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") String movieId){
        return movieService.getMovieById(movieId);
    }
    
    @RequestMapping("/movies")
    public List<Movie> getAllMovie(){
        return movieService.getAllMovies();
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/movies")
    public void addMovieInfo(@RequestBody Movie movie){
        movieService.addMovieInfo(movie);
    }

}
