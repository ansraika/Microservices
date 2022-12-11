package com.microservice.moviecatalogservice.models;

public class CatalogItem {
    
    private String name;
    private String movieId;
    private int rating;
    
    public CatalogItem(String name, String movieId, int rating) {
        this.name = name;
        this.movieId = movieId;
        this.rating = rating;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMovieId() {
        return movieId;
    }
    
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
}
