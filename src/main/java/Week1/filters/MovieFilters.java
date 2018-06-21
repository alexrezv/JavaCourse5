package Week1.filters;

import Week1.Movie;

import java.util.ArrayList;

public interface MovieFilters {

    long howManyComedyMovies(ArrayList<Movie> moviesList);

    long howManyMoviesLongerThan(ArrayList<Movie> moviesList, int duration);

    long howManyMoviesByOneDirector(ArrayList<Movie> moviesList);

    long howManyMoviesByDirector(ArrayList<Movie> moviesList, String director);

    String getDirectorsWithNumOfMovies(ArrayList<Movie> moviesList, int moviesNum);

}
