package Week3;

/**
 * Create a new class named MovieRunnerWithFilters that you will use to find the average rating of movies using
 * different filters. Copy the printAverageRatings method from the MovieRunnerAverage class into this class.
 * You will make several changes to this method:
 */

public class MovieRunnerWithFilters {

    public static void printAverageRatings() {
        String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        //You’ll call the MovieDatabase initialize method with the moviefile to set up the movie database.
        MovieDatabase.initialize(movieFile);

        //Instead of creating a SecondRatings object, you will create a ThirdRatings object. Note that this only has
        // one parameter, the name of a file with ratings data.
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        //Print the number of raters after creating a ThirdsRating object.
        System.out.println("Number of raters:" + thirdRatings.getNumberOfRaters());


        //Print the number of movies in the database.
        System.out.println("Number of movies:" + MovieDatabase.size());

        //You will call getAverageRatings with a minimal number of raters to return an ArrayList of type Rating.
        //Print out how many movies with ratings are returned, then sort them, and print out the rating and title of each movie.
        thirdRatings.printAverageRatings(1);

        //You will use the YearsAfterFilter to calculate the number of movies in the database that have at least a
        // minimal number of ratings and came out in a particular year or later.


        //System.out.println("Movies with 50+ ratings: " + secondRatings.getRFilters().countMoviesWithOrMoreRatings(50));
    }


}
