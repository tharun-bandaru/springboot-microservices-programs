import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashokit.beans.MovieLister;
import com.ashokit.config.AppConfig;
import com.ashokit.pojo.Movie;

public class Tester {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MovieLister lister = context.getBean(MovieLister.class);
		
		List<Movie> lstOfMovies = lister.getMoviesByYear(2023);
		
		lstOfMovies.forEach(System.out::println);
		

	}

}
