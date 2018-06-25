package Week2;

/**
 * Create a new class named MovieRunnerAverage. In this class, create a void method named printAverageRatings that has
 * no parameters. This method should:
 * <p>
 * - Create a SecondRatings object and use the CSV filenames of movie information and ratings information from the first
 * assignment when calling the constructor.
 * <p>
 * - Print the number of movies and number of raters from the two files by calling the appropriate methods in the
 * SecondRatings class. Test your program to make sure it is reading in all the data from the two files.
 * For example, if you run your program on the files ratings_short.csv and ratedmovies_short.csv,
 * you should see 5 raters and 5 movies.
 */

public class MovieRunnerAverage {

    public static void printAverageRatings() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        SecondRatings secondRatings = new SecondRatings(movieFile, ratingsFile);

        System.out.println("Total movies: " + secondRatings.getMovieSize());
        System.out.println("Total raters: " + secondRatings.getRaterSize());

        secondRatings.printAverageRatings();

        System.out.println("Movies with 50+ ratings: " + secondRatings.getRFilters().countMoviesWithOrMoreRatings(50));
    }

    //In the MovieRunnerAverage class, write the void method getAverageRatingOneMovie, which has no parameters.
    //This method should first create a SecondRatings object, reading in data from the movie and ratings data files.
    // Then this method should print out the average ratings for a specific movie title, such as the movie
    // “The Godfather”. If the moviefile is set to the file named ratedmovies_short.csv, and the ratingsfile is set
    // to the file ratings_short.csv, then the average for the movie “The Godfather” would be 9.0.
    public static void getAverageRatingOneMovie() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        SecondRatings secondRatings = new SecondRatings(movieFile, ratingsFile);

        System.out.println("Avg rating for \"The Maze Runner\" is "
                + secondRatings.getAverageRatingByTitle("The Maze Runner", 3));

        System.out.println("Avg rating for \"Moneyball\" is "
                + secondRatings.getAverageRatingByTitle("Moneyball", 3));

        System.out.println("Avg rating for \"Vacation\" is "
                + secondRatings.getAverageRatingByTitle("Vacation", 3));

    }

}
