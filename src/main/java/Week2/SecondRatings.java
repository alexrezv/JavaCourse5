package Week2;

import Week1.FirstRatings;
import Week1.Movie;
import Week1.Rater;
import Week1.Rating;
import Week1.filters.MovieFiltersImpl;
import Week1.filters.RaterFiltersImpl;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * In this assignment you will modify a new class named SecondRatings, which has been started for you, to do many of the
 * calculations focusing on computing averages on movie ratings. You will also create a second new class named
 * MovieRunnerAverage, which you will use to test the methods you created in SecondRatings by creating a SecondRatings
 * object in MovieRunnerAverage and calling its methods.
 *
 * @author alexrezv
 * @version 21.06.2018
 */

@Getter
public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    private RaterFiltersImpl rFilters;
    private MovieFiltersImpl mFilters;

    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }

    //Write an additional SecondRatings constructor that has two String parameters named moviefile and ratingsfile.
    //The constructor should create a FirstRatings object and then call the loadMovies and loadRaters methods in
    //FirstRatings to read in all the movie and ratings data and store them in the two private ArrayList variables of
    //the SecondRatings class, myMovies and myRaters.
    public SecondRatings(String movieFile, String ratingsFile) {
        myMovies = FirstRatings.loadMovies(movieFile);
        myRaters = FirstRatings.loadRaters(ratingsFile);
        rFilters = new RaterFiltersImpl(myRaters);
        mFilters = new MovieFiltersImpl(myMovies);
    }

    //In the SecondRatings class, write a public method named getMovieSize, which returns the number of movies that were
    // read in and stored in the ArrayList of type Movie.
    int getMovieSize() {
        return myMovies.size();
    }

    //In the SecondRatings class, write a public method named getRaterSize, which returns the number of raters that were
    // read in and stored in the ArrayList of type Rater.
    int getRaterSize() {
        return myRaters.size();
    }

    //In the MovieRunnerAverage class in the printAverageRatings method, add code to print a list of movies and their
    // average ratings, for all those movies that have at least a specified number of ratings, sorted by averages.
    // Specifically, this method should print the list of movies, one movie per line (print its rating first, followed
    // by its title) in sorted order by ratings, lowest rating to highest rating. For example, if printAverageRatings is
    // called on the files ratings_short.csv and ratedmovies_short.csv with the argument 3, then the output will display
    // two movies:
    //  8.25 Her
    //  9.0 The Godfather
    public void printAverageRatings() {
        ArrayList<Rating> ratings = rFilters.getAverageRatings(20);
        Map<String, Double> titleToAvg = ratings.stream()
                .collect(Collectors.toMap(r -> mFilters.getTitleById(r.getItem()), Rating::getValue));
        MapUtil.sortByValue(titleToAvg).forEach((key, value) -> System.out.println(value + " \t" + key));
    }

    public double getAverageRatingByTitle(String movieTitle, int minimalRaters) {

        String movieId = mFilters.getIdByTitle(movieTitle);
        return rFilters.getAverageRatingByMovieID(movieId, minimalRaters);
    }


}
