package Week3;

import Week1.Rating;
import Week3.filters.impl.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a new class named MovieRunnerWithFilters that you will use to find the average rating of movies using
 * different filters. Copy the printAverageRatings method from the MovieRunnerAverage class into this class.
 * You will make several changes to this method:
 */

public class MovieRunnerWithFilters {

    public static void printAverageRatings() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

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
        thirdRatings.printAverageRatings(35);

        //You will use the YearsAfterFilter to calculate the number of movies in the database that have at least a
        // minimal number of ratings and came out in a particular year or later.


        //System.out.println("Movies with 50+ ratings: " + secondRatings.getRFilters().countMoviesWithOrMoreRatings(50));
    }


    //In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByYear that should be similar
    // to printAverageRatings, but should also create a YearAfterFilter and call getAverageRatingsByFilter to get an
    // ArrayList of type Rating of all the movies that have a specified number of minimal ratings and came out in a
    // specified year or later. Print the number of movies found, and for each movie found, print its rating, its year,
    // and its title. For example, if you run the printAverageRatingsByYear method on the files ratings_short.csv and
    // ratedmovies_short.csv with a minimal rater of 1 and the year 2000
    public static void printAverageRatingsByYear() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        YearsAfterFilter yearFilter = new YearsAfterFilter(2000);

        List<Rating> avgRatings =
                thirdRatings.getAverageRatingsByFilter(20, yearFilter).stream()
                        .filter(r -> r.getValue() > 0).collect(Collectors.toList());

        System.out.println("Number of movies: " + avgRatings.size());

        for (Rating r : avgRatings) {
            System.out.println(r.getValue() + "\t" +
                    MovieDatabase.getYear(r.getItem()) + "\t" +
                    MovieDatabase.getTitle(r.getItem()));
        }
    }

    //In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByGenre that should create a
    // GenreFilter and call getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies that have a
    // specified number of minimal ratings and include a specified genre. Print the number of movies found, and for each
    // movie, print its rating and its title on one line, and its genres on the next line. For example, if you run the
    // printAverageRatingsByGenre method on the files ratings_short.csv and ratedmovies_short.csv with a minimal rater
    // of 1 and the genre “Crime”
    public static void printAverageRatingsByGenre() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        GenreFilter genreFilter = new GenreFilter("Comedy");

        List<Rating> avgRatings =
                thirdRatings.getAverageRatingsByFilter(20, genreFilter).stream()
                        .filter(r -> r.getValue() > 0).collect(Collectors.toList());

        System.out.println("Number of movies: " + avgRatings.size());

        for (Rating r : avgRatings) {
            System.out.println(r.getValue() + "\t" +
                    MovieDatabase.getTitle(r.getItem()) + "\n\t" +
                    MovieDatabase.getGenres(r.getItem()));
        }

    }

    //In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByMinutes that should create a
    // MinutesFilter and call getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies that have a
    // specified number of minimal ratings and their running time is at least a minimum number of minutes and no more
    // than a maximum number of minutes. Print the number of movies found, and for each movie print its rating, its
    // running time, and its title on one line. For example, if you run the printAverageRatingsByMinutes method on the
    // files ratings_short.csv and ratedmovies_short.csv with a minimal rater of 1, minimum minutes of 110, and maximum
    // minutes of 170
    public static void printAverageRatingsByMinutes() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        MinutesFilter minutesFilter = new MinutesFilter(105, 135);

        List<Rating> avgRatings =
                thirdRatings.getAverageRatingsByFilter(5, minutesFilter).stream()
                        .filter(r -> r.getValue() > 0).collect(Collectors.toList());

        System.out.println("Number of movies: " + avgRatings.size());

        for (Rating r : avgRatings) {
            System.out.println(r.getValue() + "\tTime: " +
                    MovieDatabase.getMinutes(r.getItem()) + "\t" +
                    MovieDatabase.getTitle(r.getItem()));
        }

    }

    //In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByDirectors that should create
    // a DirectorsFilter and call getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies that
    // have a specified number of minimal ratings and include at least one of the directors specified. Print the number
    // of movies found, and for each movie print its rating and its title on one line, and all its directors on the next
    // line. For example, if you run the printAverageRatingsByDirectors method on the files ratings_short.csv and
    //ratedmovies_short.csv with a minimal rater of 1 and the directors set to "Charles Chaplin,Michael Mann,Spike Jonze"
    public static void printAverageRatingsByDirectors() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        DirectorsFilter directorsFilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese," +
                "Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");

        List<Rating> avgRatings =
                thirdRatings.getAverageRatingsByFilter(4, directorsFilter).stream()
                        .filter(r -> r.getValue() > 0).collect(Collectors.toList());

        System.out.println("Number of movies: " + avgRatings.size());

        for (Rating r : avgRatings) {
            System.out.println(r.getValue() + "\t" +
                    MovieDatabase.getTitle(r.getItem()) + "\n\t" +
                    MovieDatabase.getDirector(r.getItem()));
        }
    }

    //In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByYearAfterAndGenre that should
    // create an AllFilters object that includes criteria based on movies that came out in a specified year or later and
    // have a specified genre as one of its genres. This method should call getAverageRatingsByFilter to get an
    // ArrayList of type Rating of all the movies that have a specified number of minimal ratings and the two criteria
    // based on year and genre. Print the number of movies found, and for each movie, print its rating, its year, and
    // its title on one line, and all its genres on the next line. For example, if you run the
    // printAverageRatingsByYearAfterAndGenre method on the files ratings_short.csv and ratedmovies_short.csv with a
    // minimal rater of 1, the year set to 1980, and the genre set to “Romance”, then you should see:
    public static void printAverageRatingsByYearAfterAndGenre() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(new GenreFilter("Drama"));
        allFilters.addFilter(new YearsAfterFilter(1990));

        List<Rating> avgRatings =
                thirdRatings.getAverageRatingsByFilter(8, allFilters).stream()
                        .filter(r -> r.getValue() > 0).collect(Collectors.toList());

        System.out.println("Number of movies: " + avgRatings.size());

        for (Rating r : avgRatings) {
            System.out.println(r.getValue() + "\t" +
                    MovieDatabase.getYear(r.getItem()) + "\t" +
                    MovieDatabase.getTitle(r.getItem()) + "\n\t" +
                    MovieDatabase.getGenres(r.getItem()));
        }
    }

    //In the MovieRunnerWithFilters class, create a void method named printAverageRatingsByDirectorsAndMinutes that
    // should create an AllFilters object that includes criteria based on running time (at least a specified minimum
    // number of minutes and at most a specified maximum number of minutes), and directors (at least one of the
    // directors in a list of specified directors—directors are separated by commas). This method should call
    // getAverageRatingsByFilter to get an ArrayList of type Rating of all the movies that have a specified number of
    // minimal ratings and the two criteria based on minutes and directors. Print the number of movies found, and for
    // each movie, print its rating, its time length, and its title on one line, and all its directors on the next line.
    // For example, if you run the printAverageRatingsByDirectorsAndMinutes method on the files ratings_short.csv and
    // ratedmovies_short.csv with a minimal rater of 1, minimum minutes set to 30, maximum minutes set to 170, and the
    // directors set to "Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola"
    public static void printAverageRatingsByDirectorsAndMinutes() {
        //String movieFile = "/home/alex/Documents/Course5/data/ratedmovies_short.csv";
        String movieFile = "/home/alex/Documents/Course5/data/ratedmoviesfull.csv";

        //String ratingsFile = "/home/alex/Documents/Course5/data/ratings_short.csv";
        String ratingsFile = "/home/alex/Documents/Course5/data/ratings.csv";

        MovieDatabase.initialize(movieFile);
        ThirdRatings thirdRatings = new ThirdRatings(ratingsFile);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(new MinutesFilter(90, 180));
        allFilters.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron," +
                "Sydney Pollack"));

        List<Rating> avgRatings =
                thirdRatings.getAverageRatingsByFilter(3, allFilters).stream()
                        .filter(r -> r.getValue() > 0).collect(Collectors.toList());

        System.out.println("Number of movies: " + avgRatings.size());

        for (Rating r : avgRatings) {
            System.out.println(r.getValue() + "\tTime: " +
                    MovieDatabase.getMinutes(r.getItem()) + "\t" +
                    MovieDatabase.getTitle(r.getItem()) + "\n\t" +
                    MovieDatabase.getDirector(r.getItem()));
        }
    }
}
