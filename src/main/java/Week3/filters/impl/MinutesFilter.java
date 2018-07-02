package Week3.filters.impl;

import Week1.Movie;
import Week3.MovieDatabase;
import Week3.filters.Filter;
import lombok.AllArgsConstructor;

/**
 * Create a new class named MinutesFilter that implements Filter. Its satisfies method should return true if a movie’s
 * running time is at least min minutes and no more than max minutes.
 */

@AllArgsConstructor
public class MinutesFilter implements Filter {
    private long minMinutes;
    private long maxMinutes;

    @Override
    public boolean satisfies(String movieId) {
        return MovieDatabase.getMinutes(movieId) >= minMinutes &&
                MovieDatabase.getMinutes(movieId) <= maxMinutes;
    }

    @Override
    public boolean satisfies(Movie movie) {
        return MovieDatabase.getMinutes(movie.getId()) >= minMinutes &&
                MovieDatabase.getMinutes(movie.getId()) <= maxMinutes;
    }
}
