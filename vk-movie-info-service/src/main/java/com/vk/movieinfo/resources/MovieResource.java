package com.vk.movieinfo.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vk.movieinfo.models.Movie;
import com.vk.movieinfo.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieResource.class);
			
	@Value("${moviedb.api.key}")
	private String apiKey;
	
	@Value("${moviedb.url}")
	private String movieDbUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

		logger.info("movieId: {}", movieId);
		
		String url = movieDbUrl + movieId + "?api_key=" + apiKey;
		MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
		
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
		
	}

}
