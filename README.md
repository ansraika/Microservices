# Microservices
Microservice architecture of 3 packages created using Springboot


### Creating a Service that will fetch movie name and its rating by giving movie id as the input

* The architecture consists of four packages : 
  * ratings-data-services
  * movie-info-services
  * movie-catalog-service
  * discovery-server
  
#### ratings-data-services
* This microservcie stores the movie Id and the movie rating. 

#### movie-info-services
* This microservcie consists of movie id and movie name. 

#### movie-catalog-service
* This microservcie takes movie id as the input, calls the ratings-data-services to get the rating and movie-info-services to get the name of the movie and gives the output in the form of : [MovieId, MovieName, MovieRating]


### Calling the microservices

* The microservice interation is happening via Eureka which is configured in the package:  **discovery-server**. 
* You need to run this package first before running any of the other packages. 
