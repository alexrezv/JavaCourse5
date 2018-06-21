package Week2;

/**
 * Create a new class named MovieRunnerAverage. In this class, create a void method named printAverageRatings that has
 * no parameters. This method should:
 *
 * - Create a SecondRatings object and use the CSV filenames of movie information and ratings information from the first
 *   assignment when calling the constructor.
 *
 * - Print the number of movies and number of raters from the two files by calling the appropriate methods in the
 *   SecondRatings class. Test your program to make sure it is reading in all the data from the two files.
 *   For example, if you run your program on the files ratings_short.csv and ratedmovies_short.csv,
 *   you should see 5 raters and 5 movies.
 */

public class MovieRunnerAverage {

    public static void printAverageRatings () {
        String movieFile = "/home/alex/Documents/Course5/src/main/java/Week1/data/ratedmovies_short.csv";
        //String movieFile = "/home/alex/Documents/Course5/src/main/java/Week1/data/ratedmoviesfull.csv";

        String ratingsFile = "/home/alex/Documents/Course5/src/main/java/Week1/data/ratings_short.csv";
        //String ratingsFile = "/home/alex/Documents/Course5/src/main/java/Week1/data/ratings.csv";

        SecondRatings secondRatings = new SecondRatings(movieFile,ratingsFile);

        System.out.println("Total movies: " + secondRatings.getMovieSize());
        System.out.println("Total raters: " + secondRatings.getRaterSize());
    }
}
