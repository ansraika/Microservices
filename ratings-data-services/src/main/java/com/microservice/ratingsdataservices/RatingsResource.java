package com.microservice.ratingsdataservices;

import com.microservice.ratingsdataservices.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratingdata")
public class RatingsResource {
    
    @Autowired
    RatingService ratingService;
    
    @RequestMapping("/{movieId}")
    public Rating getRatingByMovieId(@PathVariable("movieId") String movieId){
        return ratingService.getRatingByMovieId(movieId);
    }
 
    @RequestMapping("")
    public List<Rating> getRatings(){
        return ratingService.getRatings();
    }
    
   
    @RequestMapping(method = RequestMethod.POST,value = "")
    public void addRating(@RequestBody Rating rating){
        ratingService.addRating(rating);
    }
    

}
