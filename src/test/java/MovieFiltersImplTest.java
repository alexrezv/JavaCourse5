import Week1.FirstRatings;
import Week1.Movie;
import Week1.filters.MovieFiltersImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MovieFiltersImplTest {

    @Test
    public void testMovieFiltersImplHasOutput() {
        MovieFiltersImpl classUnderTest = new MovieFiltersImpl();

        FirstRatings fr = new FirstRatings();
        ArrayList<Movie> list = fr.loadMovies("/home/alex/Documents/Course5/src/main/java/Week1/data/ratedmoviesfull.csv");

        assertNotNull(classUnderTest.howManyComedyMovies(list));
    }
}
