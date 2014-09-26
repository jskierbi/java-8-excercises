package pl.touk.wasjawa.java8.exercise.ex08;

import pl.touk.wasjawa.java8.exercise.common.movies.Actor;
import pl.touk.wasjawa.java8.exercise.common.movies.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private final static StupidLogger LOGGER = new StupidLogger(LoggerMode.DEBUG);

    public List<String> actorsToActorsNames(Movie movie) {

	    return movie.getActors().stream()
			    .map(Actor::getName)
			    .peek(a -> LOGGER.debug(() -> "Find actor: " + a))
			    .collect(Collectors.toList());
    }

}
