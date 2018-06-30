package Week3.filters.impl;

import Week1.Movie;
import Week3.MovieDatabase;
import Week3.filters.Filter;
import lombok.AllArgsConstructor;

/**
 * The class YearsAfterFilter is a filter for a specified year; it selects only those movies that were created on that
 * year or created later than that year. If the year is 2000, then all movies created in the year 2000 and the years
 * after (2001, 2002, 2003, etc) would be selected if used with MovieDatabase.filterBy.
 */

@AllArgsConstructor
public class YearsAfterFilter implements Filter {
    private int year;

    @Override
    public boolean satisfies(String movieId) {
        return MovieDatabase.getYear(movieId) >= year;
    }

    @Override
    public boolean satisfies(Movie movie) {
        return MovieDatabase.getYear(movie.getId()) >= year;
    }
}
