import Week1.FirstRatings;
import Week1.Movie;
import Week1.filters.MovieFiltersImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MovieFiltersImplTest {

    @Test
    public void testMovieFiltersImplHasOutput() {
        ArrayList<Movie> moviesList =
                FirstRatings.loadMovies(
                        "/home/alex/Documents/Course5/src/main/java/Week1/data/ratedmoviesfull.csv");

        MovieFiltersImpl classUnderTest = new MovieFiltersImpl(moviesList);

        assertNotNull(classUnderTest.howManyComedyMovies());
    }
}
