package Week1.filters;

import Week1.Movie;

import java.util.ArrayList;

public interface MovieFilters {

    public long howManyComedyMovies(ArrayList<Movie> moviesList);

    public long howManyMoviesLongerThan(ArrayList<Movie> moviesList, int duration);

    public long howManyMoviesByDirector(ArrayList<Movie> moviesList, String director);

    public String getDirectorsWithNumOfMovies(ArrayList<Movie> moviesList, int moviesNum);

}
