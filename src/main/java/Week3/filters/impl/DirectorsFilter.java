package Week3.filters.impl;

import Week1.Movie;
import Week3.MovieDatabase;
import Week3.filters.Filter;
import lombok.AllArgsConstructor;

/**
 * Create a new class named DirectorsFilter that implements Filter. The constructor should have one parameter named
 * directors representing a list of directors separated by commas (Example: "Charles Chaplin,Michael Mann,Spike Jonze",
 * and its satisfies method should return true if a movie has at least one of these directors as one of its directors.
 * Note that each movie may have several directors.
 */

@AllArgsConstructor
public class DirectorsFilter implements Filter {
    private String director;

    @Override
    public boolean satisfies(String movieId) {
        for (String s : director.split(",")) {
            if (MovieDatabase.getDirector(movieId).contains(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean satisfies(Movie movie) {
        for (String s : director.split(",")) {
            if (MovieDatabase.getDirector(movie.getDirector()).contains(s)) {
                return true;
            }
        }
        return false;
    }
}
