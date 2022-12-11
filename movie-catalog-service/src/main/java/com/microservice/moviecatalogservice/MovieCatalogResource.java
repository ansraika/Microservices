package com.microservice.moviecatalogservice;


import com.microservice.moviecatalogservice.models.CatalogItem;
import com.microservice.moviecatalogservice.models.Movie;
import com.microservice.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog/")
public class MovieCatalogResource {
    
    List<Rating> ratings = new ArrayList<>();
    List<Movie> movies = new ArrayList<>();
    List<CatalogItem> catalogItems = new ArrayList<>();
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    

    @RequestMapping("")
    public List<CatalogItem> getCatalogForMovieId(){
        
        ratings =  webClientBuilder.build()
                .get()
                .uri("http://ratings-data-services:8082/ratingdata")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Rating>>() {})
                .block();
        
         return ratings.stream().map(rating -> {
            //Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);
             Movie movie = webClientBuilder.build()
                     .get()
                     .uri("http://movie-info-services/movies/"+rating.getMovieId())
                     .retrieve()
                     .bodyToMono(Movie.class)
                     .block();
              // in uri , the "movie-info-services" mentioned after "http:" is actually yhe name of the application registered in discovery-server (Eureka Server)
             return new CatalogItem(movie.getName(),rating.getMovieId(),rating.getRating());
        }).collect(Collectors.toList());
        
    }

}
