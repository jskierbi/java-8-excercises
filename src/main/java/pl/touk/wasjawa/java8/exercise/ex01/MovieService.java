package pl.touk.wasjawa.java8.exercise.ex01;

import pl.touk.wasjawa.java8.exercise.common.CountryCode;
import pl.touk.wasjawa.java8.exercise.common.movies.Actor;
import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

	public List<String> polishActorNames(Movie movie) {
//		List<String> polishActorNames = new ArrayList<>();
//		for (Actor actor : movie.getActors()) {
//			if (actor.getCountryOfBirth() == CountryCode.PL) {
//				polishActorNames.add(actor.getName());
//			}
//		}
//		return polishActorNames;

		return movie.getActors().stream()
				.filter(actor -> actor.getCountryOfBirth() == CountryCode.PL)
				.map(Actor::getName)
				.collect(Collectors.toList());
	}

}
