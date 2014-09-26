package pl.touk.wasjawa.java8.exercise.ex06;

import pl.touk.wasjawa.java8.exercise.common.CountryCode;
import pl.touk.wasjawa.java8.exercise.common.movies.Actor;
import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieService {

    public Map<CountryCode, List<String>> actorsNamesGroupByCountries(Movie movie) {
//        Map<CountryCode, List<String>> groupedActors = new HashMap<>();
//        for (Actor actor : movie.getActors()) {
//            List<String> actors = groupedActors.get(actor.getCountryOfBirth());
//            if (actors == null) {
//                actors = new ArrayList<>();
//                groupedActors.put(actor.getCountryOfBirth(), actors);
//            }
//            actors.add(actor.getName());
//        }
//        return groupedActors;

	    return movie.getActors().stream()
			    .collect(Collectors.groupingBy(
					    Actor::getCountryOfBirth,
					    Collectors.mapping(Actor::getName, Collectors.toList())));
    }

}
