package Week1.filters;

public interface RaterFilters {

    long howManyRatingsByRaterId(String id);

    long maxRatingsByAnyRater();

    String getRatersWithNumOfRatings(int ratingsNum);

    long howManyRatingsByMovieId(String movieId);

    long howManyMoviesHaveBeenRated();
}
