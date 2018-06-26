import Week1.FirstRatings;
import Week1.Movie;
import Week1.filters.MovieFiltersImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieFiltersImplTest {

    @Test
    public void testMovieFiltersImplHasOutput() {
        ArrayList<Movie> moviesList =
                FirstRatings.loadMovies(
                        "/home/alex/Documents/Course5/data/ratedmoviesfull.csv");

        MovieFiltersImpl classUnderTest = new MovieFiltersImpl(moviesList);

        assertNotNull(classUnderTest.howManyComedyMovies());
    }

    @Test
    public void testGetTitleById() {
        ArrayList<Movie> moviesList =
                FirstRatings.loadMovies(
                        "/home/alex/Documents/Course5/data/ratedmoviesfull.csv");

        MovieFiltersImpl classUnderTest = new MovieFiltersImpl(moviesList);

        assertEquals(classUnderTest.getTitleById("0068646"), "The Godfather");
        assertEquals(classUnderTest.getTitleById("0068646"), "The Godfather");
    }

    @Test
    public void testGetIdByTitle() {
        ArrayList<Movie> moviesList =
                FirstRatings.loadMovies(
                        "/home/alex/Documents/Course5/data/ratedmoviesfull.csv");

        MovieFiltersImpl classUnderTest = new MovieFiltersImpl(moviesList);

        assertEquals(classUnderTest.getIdByTitle("The Godfather"), "68646");
    }
}
