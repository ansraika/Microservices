package com.microservice.movieinfoservices;

import com.microservice.movieinfoservices.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {
    List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("0","default")
    ));
    
    
    public void addMovieInfo(Movie movie){
        movies.add(movie);
        
    }
    
    public Movie getMovieById(String movieId){
        return movies.stream().filter(movie -> movie.getMovieId().equals(movieId)).findFirst().get();
    }
    
    public List<Movie> getAllMovies(){
        return movies;
    }
    
    
}
