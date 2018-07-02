package Week3;

import Week1.FirstRatings;
import Week1.Movie;
import Week3.filters.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is an efficient way to get information about movies. It stores movie information in a HashMap for fast
 * lookup of movie information given a movie ID. The class also allows filtering movies based on queries. All methods
 * and fields in the class are static. This means you'll be able to access methods in MovieDatabase without using new
 * to create objects, but by calling methods like MovieDatabase.getMovie("0120915"). This class has the following parts:
 */
public class MovieDatabase {
    //A HashMap named ourMovies that maps a movie ID String to a Movie object with all the information about that movie.
    private static Map<String, Movie> movieIdToMovieMap;

    //A public initialize method with one String parameter named moviefile.
    // You can call this method with the name of the file used to initialize the movie database.
    public static void initialize(String movieFile) {
        if (movieIdToMovieMap == null) {
            movieIdToMovieMap = new HashMap<>();
            loadMovies(movieFile);
        }
    }

    //A private initialize method with no parameters that will load the movie file ratedmoviesfull.csv if no file has
    // been loaded. This method is called as a safety check with any of the other public methods to make sure there is
    // movie data in the database.
    private static void initialize() {
        if (movieIdToMovieMap == null) {
            movieIdToMovieMap = new HashMap<>();
            loadMovies("/home/alex/Documents/Course5/data/ratedmoviesfull.csv");
        }
    }

    //A private loadMovies method to build the HashMap.
    private static void loadMovies(String movieFile) {
        movieIdToMovieMap = FirstRatings.loadMovies(movieFile).stream().
                collect(Collectors.toMap(Movie::getId, movie -> movie, (v1, v2) -> v2));
    }

    //A containsID method with one String parameter named id. This method returns true if the id is a movie in the
    // database, and false otherwise.
    public static boolean containsId(String id) {
        return movieIdToMovieMap.keySet().contains(id);
    }

    //Several getter methods including getYear, getTitle, getMovie, getPoster, getMinutes, getCountry, getGenres,
    // and getDirector. Each of these takes a movie ID as a parameter and returns information about that movie.
    public static Movie getMovie(String movieId) {
        return movieIdToMovieMap.get(movieId);
    }

    public static String getTitle(String movieId) {
        return getMovie(movieId).getTitle();
    }

    public static int getYear(String movieId) {
        return getMovie(movieId).getYear();
    }

    public static String getGenres(String movieId) {
        return getMovie(movieId).getGenres();
    }

    public static String getDirector(String movieId) {
        return getMovie(movieId).getDirector();
    }

    public static String getCountry(String movieId) {
        return getMovie(movieId).getCountry();
    }

    public static String getPoster(String movieId) {
        return getMovie(movieId).getPoster();
    }

    public static int getMinutes(String movieId) {
        return getMovie(movieId).getMinutes();
    }

    //A size method that returns the number of movies in the database.
    public static long size() {
        return movieIdToMovieMap.size();
    }

    //A filterBy method that has one Filter parameter named f. This method returns an ArrayList of type String of movie
    // IDs that match the filtering criteria.
    public static ArrayList<String> filterIdsBy(Filter f) {
        initialize();
        ArrayList<String> matchedMovies = new ArrayList<>();
        for (String id : movieIdToMovieMap.keySet()) {
            if (f.satisfies(id)) {
                matchedMovies.add(id);
            }
        }

        return matchedMovies;
    }

    public static ArrayList<Movie> filterMoviesBy(Filter f) {
        initialize();
        ArrayList<Movie> matchedMovies = new ArrayList<>();
        for (Movie movie : movieIdToMovieMap.values()) {
            if (f.satisfies(movie)) {
                matchedMovies.add(movie);
            }
        }

        return matchedMovies;
    }
}
