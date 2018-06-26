package Week1.filters;

public interface MovieFilters {

    long howManyMoviesOfGenre(String genre);

    long howManyMoviesLongerThan(int duration);

    long howManyMoviesByOneDirector();

    long howManyMoviesByDirector(String director);

    String getDirectorsWithNumOfMovies(int moviesNum);

}
