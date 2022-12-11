package com.microservice.ratingsdataservices;


import com.microservice.ratingsdataservices.models.Rating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RatingService {

    List<Rating> ratings = new ArrayList<>();
    
    public RatingService() {
        ratings.add(new Rating("0", 0));
    }
    
    public List<Rating> getRatings(){
        return ratings;
    }
    
    public void addRating(Rating rating){
        ratings.add(rating);
    }
    
    public Rating getRatingByMovieId(String movieId){
        return ratings.stream().filter(rating -> rating.getMovieId().equals(movieId)).findFirst().get();
    }
    
}
