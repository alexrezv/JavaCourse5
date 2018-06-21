package Week1.filters;

public interface RaterFilters {

    long howManyRatingsForRaterById(String id);

    long maxRatingsByAnyRater();

    String getRatersWithNumOfRatings(int ratingsNum);

    long howManyRatingsForAMovieById(String movieId);

    long howManyMoviesHaveBeenRated();
}
