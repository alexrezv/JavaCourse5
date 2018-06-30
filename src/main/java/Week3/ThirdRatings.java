package Week3;

import Week1.FirstRatings;
import Week1.Movie;
import Week1.Rater;
import Week1.Rating;
import Week1.filters.MovieFiltersImpl;
import Week1.filters.RaterFiltersImpl;
import Week2.MapUtil;
import Week3.filters.impl.TrueFilter;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create a new class named ThirdRatings. Copy your code from SecondRatings into this class. Movies will now be stored
 * in the MovieDatabase instead of in the instance variable myMovies, so you will want to remove the private variable
 * myMovies. The constructor will no longer have a moviefile parameter—movies will be stored in the MovieDatabase class.
 * <p>
 * ThirdRatings has only one private variable named myRaters to store an ArrayList of Raters.
 */

public class ThirdRatings {

    private ArrayList<Rater> raters;
    private RaterFiltersImpl rFilters;
    private MovieFiltersImpl mFilters;

    //The default constructor should look like this:
    public ThirdRatings() {
        this("ratings.csv");
    }

    //A second constructor should have only one String parameter named ratingsfile. This constructor should call the
    // method loadRaters from the FirstRatings class to fill the myRaters ArrayList.
    public ThirdRatings(String ratingsFile) {
        raters = FirstRatings.loadRaters(ratingsFile);
        rFilters = new RaterFiltersImpl(raters);
        ArrayList<Movie> movies = MovieDatabase.filterMoviesBy(new TrueFilter());
        mFilters = new MovieFiltersImpl(movies);
    }

    //You will need to modify getAverageRatings. Note that myMovies no longer exists. Instead, you’ll need to get all
    // the movies from the MovieDatabase class and store them in an ArrayList of movie IDs. Thus, you will need to
    // modify getAverageRatings to call MovieDatabase with a filter, and in this case you can use the TrueFilter to
    // get every movie.
    public void printAverageRatings(int minimalRaters) {
        ArrayList<Rating> ratings = rFilters.getAverageRatings(minimalRaters);
        Map<String, Double> titleToAvg = ratings.stream()
                .collect(Collectors.toMap(r -> mFilters.getTitleById(r.getItem()), Rating::getValue));
        MapUtil.sortByValue(titleToAvg).forEach((key, value) -> System.out.println(value + " \t" + key));
    }

    public long getNumberOfRaters() {
        return raters.stream().map(Rater::getId).distinct().count();
    }

    //In the ThirdRatings class, write a public helper method named getAverageRatingsByFilter that has two
    // parameters, an int named minimalRaters for the minimum number of ratings a movie must have and a Filter named
    // filterCriteria. This method should create and return an ArrayList of type Rating of all the movies that have
    // at least minimalRaters ratings and satisfies the filter criteria. This method will need to create the
    // ArrayList of type String of movie IDs from the MovieDatabase using the filterBy method before calculating
    // those averages.
    public ArrayList<Rating> getAverageRatingsByFilter() {

        return null;
    }
}
