package Week3.filters.impl;

import Week1.Movie;
import Week3.filters.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * The class AllFilters combines several filters. This class has the following:
 */

public class AllFilters implements Filter {
    //A private variable named filters that is an ArrayList of type Filter.
    private List<Filter> filters;

    public AllFilters() {
        filters = new ArrayList<>();
    }

    //An addFilter method that has one parameter named f of type Filter. This method allows one to add a Filter to
    // the ArrayList filters.
    public void addFilter(Filter f) {
        filters.add(f);
    }

    //A satisfies method that has one parameter named id representing a movie ID. This method returns true if the movie
    // satisfies the criteria of all the filters in the filters ArrayList. Otherwise this method returns false.
    @Override
    public boolean satisfies(String movieId) {
        for (Filter f : filters) {
            if (f.satisfies(movieId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean satisfies(Movie movie) {
        for (Filter f : filters) {
            if (f.satisfies(movie)) {
                return true;
            }
        }
        return false;
    }
}
