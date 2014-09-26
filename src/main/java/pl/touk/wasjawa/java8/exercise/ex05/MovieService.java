package pl.touk.wasjawa.java8.exercise.ex05;

import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.IntSummaryStatistics;
import java.util.List;

public class MovieService {

    public MoviesReleaseYearStatistics calculateMoviesStats(List<Movie> movies) {
        if (movies.isEmpty()) {
            throw new IllegalArgumentException("Empty movies list");
        }

	    IntSummaryStatistics stats = movies.stream()
			    .mapToInt(Movie::getReleaseYear)
			    .summaryStatistics();
	    return new MoviesReleaseYearStatistics(stats.getMin(), stats.getMax(), stats.getAverage());
    }

}
