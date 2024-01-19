package com.ashokit.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.pojo.Movie;
import com.ashokit.pojo.MovieFinder;

@Component
public class MovieLister {

	@Autowired
	MovieFinder movieFinder;
	
	public List<Movie> getMoviesByYear(int year)
	{
		return movieFinder.fetchMoviesByYear(year);
	}
}
