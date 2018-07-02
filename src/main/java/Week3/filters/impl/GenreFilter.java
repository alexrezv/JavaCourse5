package Week3.filters.impl;

import Week1.Movie;
import Week3.MovieDatabase;
import Week3.filters.Filter;
import lombok.AllArgsConstructor;

/**
 * Create a new class named GenreFilter that implements Filter. The constructor should have one parameter named genre
 * representing one genre, and the satisfies method should return true if a movie has this genre. Note that movies may
 * have several genres.
 */

@AllArgsConstructor
public class GenreFilter implements Filter {
    private String genre;

    @Override
    public boolean satisfies(String movieId) {
        return MovieDatabase.getGenres(movieId).contains(genre);
    }

    @Override
    public boolean satisfies(Movie movie) {
        return MovieDatabase.getGenres(movie.getGenres()).contains(genre);
    }
}
