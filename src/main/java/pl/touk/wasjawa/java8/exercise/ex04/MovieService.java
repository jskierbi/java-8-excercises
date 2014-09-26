package pl.touk.wasjawa.java8.exercise.ex04;

import pl.touk.wasjawa.java8.exercise.common.CountryCode;
import pl.touk.wasjawa.java8.exercise.common.movies.Actor;
import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

	public static final int NEW_MOVIE_YEAR_LIMIT = 2000;

	public List<String> polishActorNamesInNewMovies(List<Movie> movies) {
		return movies.stream()
				.filter(movie -> movie.getReleaseYear() > NEW_MOVIE_YEAR_LIMIT)
				.flatMap(movie -> movie.getActors().stream())
				.filter(actor -> actor.getCountryOfBirth() == CountryCode.PL)
				.map(Actor::getName)
				.collect(Collectors.toList());
	}
}
