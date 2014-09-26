package pl.touk.wasjawa.java8.exercise.ex05;

import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.IntSummaryStatistics;
import java.util.List;

public class MovieService {

    public MoviesReleaseYearStatistics calculateMoviesStats(List<Movie> movies) {
        if (movies.isEmpty()) {
            throw new IllegalArgumentException("Empty movies list");
        }

//	    int releaseYearSum = 0;
//	    int oldestMovieYear = movies.get(0).getReleaseYear();
//	    int newestMovieYear = movies.get(0).getReleaseYear();
//	    for (Movie movie : movies) {
//		    releaseYearSum += movie.getReleaseYear();
//		    if (oldestMovieYear > movie.getReleaseYear()) {
//			    oldestMovieYear = movie.getReleaseYear();
//		    }
//		    if (newestMovieYear < movie.getReleaseYear()) {
//			    newestMovieYear = movie.getReleaseYear();
//		    }
//	    }
//	    double averageReleaseYear = 1.0 * releaseYearSum / movies.size();
//	    return new MoviesReleaseYearStatistics(stats.getMin(), stats.getMax(), stats.getAverage());

	    IntSummaryStatistics stats = movies.stream()
			    .mapToInt(Movie::getReleaseYear)
			    .summaryStatistics();
	    return new MoviesReleaseYearStatistics(stats.getMin(), stats.getMax(), stats.getAverage());
    }

}
