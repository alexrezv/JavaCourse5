import Week1.FirstRatings;
import Week1.Movie;
import Week1.Rater;
import Week1.filters.MovieFiltersImpl;
import Week1.filters.RaterFiltersImpl;

import java.util.ArrayList;

public class App {
    String getGreeting() {
        return "\n=== Course 5 Week 1 ===\n";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        FirstRatings fr = new FirstRatings();
        //ArrayList<Movie> list = fr.loadMovies("/home/alex/Documents/Course5/src/main/java/Week1/data/ratedmovies_short.csv");
        ArrayList<Movie> list = fr.loadMovies("/home/alex/Documents/Course5/src/main/java/Week1/data/ratedmoviesfull.csv");

        MovieFiltersImpl filters = new MovieFiltersImpl();
        System.out.println("Comedy movies: " + filters.howManyComedyMovies(list));
        System.out.println("Movies longer 150min: " + filters.howManyMoviesLongerThan(list, 150));
        System.out.println("Max movies by one director: " + filters.howManyMoviesByOneDirector(list));
        System.out.println("Movies by: " + filters.howManyMoviesByDirector(list, "David Cronenberg"));
        System.out.println("Directors with # movie(s): " + filters.getDirectorsWithNumOfMovies(list, 23));

        //ArrayList<Rater> lst = fr.loadRaters("/home/alex/Documents/Course5/src/main/java/Week1/data/ratings_short.csv");
        ArrayList<Rater> lst = fr.loadRaters("/home/alex/Documents/Course5/src/main/java/Week1/data/ratings.csv");
        RaterFiltersImpl fltrs = new RaterFiltersImpl();
        System.out.println("Rating for rater #: " + fltrs.howManyRatingsForRaterById(lst, "193"));
        System.out.println("Max rating by any rater: " + fltrs.maxRatingsByAnyRater(lst));
        System.out.println("Raters with # ratings: " + fltrs.getRatersWithNumOfRatings(lst, 314));
        System.out.println("# ratings for a movie #: " + fltrs.howManyRatingsForAMovieById(lst, "1798709"));
        System.out.println("How many movies have been rated: " + fltrs.howManyMoviesHaveBeenRated(lst));
    }
}

