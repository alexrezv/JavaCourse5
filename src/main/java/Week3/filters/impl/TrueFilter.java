package Week3.filters.impl;

import Week1.Movie;
import Week3.filters.Filter;

/**
 * The class TrueFilter can be used to select every movie from MovieDatabase. It’s satisfies method always returns true.
 */

public class TrueFilter implements Filter {

    @Override
    public boolean satisfies(String movieId) {
        return true;
    }

    @Override
    public boolean satisfies(Movie movie) {
        return true;
    }
}
