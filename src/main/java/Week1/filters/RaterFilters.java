package Week1.filters;

import Week1.Rater;

import java.util.ArrayList;

public interface RaterFilters {

    long howManyRatingsForRaterById(ArrayList<Rater> list, String id);

    long maxRatingsByAnyRater(ArrayList<Rater> list);

    String getRatersWithNumOfRatings(ArrayList<Rater> raters, int ratingsNum);

    long howManyRatingsForAMovieById(ArrayList<Rater> raterList, String movieId);

    long howManyMoviesHaveBeenRated(ArrayList<Rater> ratersList);
}
