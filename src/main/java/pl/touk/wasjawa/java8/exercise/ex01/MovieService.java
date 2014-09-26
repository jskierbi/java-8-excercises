package pl.touk.wasjawa.java8.exercise.ex01;

import pl.touk.wasjawa.java8.exercise.common.CountryCode;
import pl.touk.wasjawa.java8.exercise.common.movies.Actor;
import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

	public List<String> polishActorNames(Movie movie) {
		return movie.getActors().stream()
				.filter(actor -> actor.getCountryOfBirth() == CountryCode.PL)
				.map(Actor::getName)
				.collect(Collectors.toList());
	}

}
