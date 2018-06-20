package Week1.filters;

import Week1.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieFiltersImpl implements MovieFilters {

    //Add code to determine how many movies include the Comedy genre. In the file ratedmovies_short.csv, there is only one.
    public long howManyComedyMovies(ArrayList<Movie> moviesList) {
        return moviesList.stream().filter(movie -> movie.getGenres().contains("Comedy")).count();
    }

    //Add code to determine how many movies are greater than 150 minutes in length. In the file ratedmovies_short.csv,
    //there are two.
    public long howManyMoviesLongerThan(ArrayList<Movie> moviesList, int duration) {
        return moviesList.stream().filter(movie -> movie.getMinutes() > duration).count();
    }

    //Add code to determine the maximum number of movies by any director,
    public long howManyMoviesByDirector(ArrayList<Movie> moviesList, String director) {
        return moviesList.stream().filter(movie -> movie.getDirector().contains(director)).count();
    }

    //and who the directors are that directed that many movies
    public String getDirectorsWithNumOfMovies(ArrayList<Movie> moviesList, int moviesNum) {
        List<String> directors = moviesList.stream()
                .collect(Collectors.toMap(o -> o.getDirector(), ignore -> 1, (v, v2) -> v + v2))
                .entrySet().stream().filter(e -> e.getValue() == moviesNum)
                .collect(Collectors.toMap(o -> o.getKey(), ignore -> 0))
                .keySet().stream().collect(Collectors.toList());

        return directors.toString();
    }
}
