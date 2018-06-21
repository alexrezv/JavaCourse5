package Week1.filters;

import Week1.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieFiltersImpl implements MovieFilters {

    private ArrayList<Movie> moviesList;

    public MovieFiltersImpl(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public long howManyMoviesOfGenre(String genre) {
        return moviesList.stream().filter(movie -> movie.getGenres().contains(genre)).count();
    }

    //Add code to determine how many movies include the Comedy genre. In the file ratedmovies_short.csv, there is only one.
    public long howManyComedyMovies() {
        return howManyMoviesOfGenre("Comedy");
    }

    //Add code to determine how many movies are greater than 150 minutes in length. In the file ratedmovies_short.csv,
    //there are two.
    public long howManyMoviesLongerThan(int duration) {
        return moviesList.stream().filter(movie -> movie.getMinutes() > duration).count();
    }

    public long howManyMoviesByOneDirector() {
        Map<String, Integer> directorsToNumOfFilms = moviesList.stream()
                .filter(e -> !e.getDirector().contains(","))
                .collect(Collectors.toMap(Movie::getDirector, ignore -> 1, (v, v2) -> v + v2));
        return directorsToNumOfFilms.values().stream().max(Comparator.naturalOrder()).orElse(-1);
    }

    //Add code to determine the maximum number of movies by any director,
    public long howManyMoviesByDirector(String director) {
        return moviesList.stream().filter(movie -> movie.getDirector().contains(director)).count();
    }

    //and who the directors are that directed that many movies
    public String getDirectorsWithNumOfMovies(int moviesNum) {
        List<String> directors = new ArrayList<>(moviesList.stream()
                .collect(Collectors.toMap(Movie::getDirector, ignore -> 1, (v, v2) -> v + v2))
                .entrySet().stream().filter(e -> e.getValue() == moviesNum)
                .collect(Collectors.toMap(Map.Entry::getKey, ignore -> 0))
                .keySet());

        return directors.toString();
    }
}
