package com.ashokit.pojo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;


@Component
public class MovieFinder {
 
	private static final Movie[] MOVIES;
	
	static {
		MOVIES = new Movie[] {
				new Movie("RRR", 2022),
				new Movie("Raangi",2022),
				new Movie("Sir",2023),
				new Movie("Dasara",2023)
				
		};
	}
	
	public List<Movie> fetchMoviesByYear(int year){
		
		List<Movie> found = new ArrayList<>();
		
		for(Movie movie: MOVIES)
		{
			if(year == movie.getYear())
			{
				found.add(movie);
			}
		}
		return found;
		
	}
}
