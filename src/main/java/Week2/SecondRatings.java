package Week2;

import Week1.FirstRatings;
import Week1.Movie;
import Week1.Rater;
import Week1.filters.RaterFiltersImpl;

import java.util.ArrayList;

/**
 * In this assignment you will modify a new class named SecondRatings, which has been started for you, to do many of the
 * calculations focusing on computing averages on movie ratings. You will also create a second new class named
 * MovieRunnerAverage, which you will use to test the methods you created in SecondRatings by creating a SecondRatings
 * object in MovieRunnerAverage and calling its methods.
 *
 * @author alexrezv
 * @version 21.06.2018
 */

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;

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

        double avg = getAverageRatingByID("113277", 5);
    }

    //In the SecondRatings class, write a public method named getMovieSize, which returns the number of movies that were
    // read in and stored in the ArrayList of type Movie.
    public int getMovieSize() {
        return myMovies.size();
    }

    //In the SecondRatings class, write a public method named getRaterSize, which returns the number of raters that were
    // read in and stored in the ArrayList of type Rater.
    public int getRaterSize() {
        return myRaters.size();
    }

    //In the SecondRatings class, write a private helper method named getAverageByID that has two parameters: a String
    // named id representing a movie ID and an integer named minimalRaters. This method returns a double representing
    // the average movie rating for this ID if there are at least minimalRaters ratings. If there are not minimalRaters
    // ratings, then it returns 0.0.
    private double getAverageRatingByID(String movieId, int minimalRaters) {
        double averageRating = 0.0;

        RaterFiltersImpl rFilters = new RaterFiltersImpl(myRaters);
/*
        if (rFilters.howManyRatingsForAMovieById(myRaters,movieId) >= minimalRaters) {
            averageRating = myRaters.stream()
                    .map(r -> r.getMyRatings().stream()
                            .filter(rating -> rating.getItem().equals(movieId)).map(Rating::getItem))
                    .;
        }
*/
        return averageRating;
    }
}
