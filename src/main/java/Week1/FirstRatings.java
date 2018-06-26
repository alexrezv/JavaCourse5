package Week1;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;

/**
 * @author AlexRezv
 * @version 18.06.2018
 */

public class FirstRatings {


    public static ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> moviesList = new ArrayList<>();

        FileResource fileResource = new FileResource(filename);

        CSVParser parser = fileResource.getCSVParser();

        for (CSVRecord line : parser) {
            Long movieId = Long.parseLong(line.get("id"));
            Movie m = new Movie(
                    movieId.toString(),
                    line.get("title"),
                    line.get("year"),
                    line.get("genre"),
                    line.get("director"),
                    line.get("country"),
                    line.get("poster"),
                    Integer.parseInt(line.get("minutes"))
            );
            moviesList.add(m);
        }

        //System.out.println("Total movies in the file: " + moviesList.stream().count());
        //moviesList.stream().forEach(System.out::println);

        return moviesList;
    }

    public static ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> ratersList = new ArrayList<>();

        FileResource fileResource = new FileResource(filename);

        CSVParser parser = fileResource.getCSVParser();

        for (CSVRecord line : parser) {
            Rater r = new Rater(line.get("rater_id"));
            if (!ratersList.stream().anyMatch(rater -> rater.getId().equals(line.get("rater_id")))) {
                ratersList.add(r);
            }
        }

        parser = fileResource.getCSVParser();
        for (CSVRecord line : parser) {
            ratersList.forEach(r -> {
                        if (r.getId().equals(line.get("rater_id"))) {
                            Long movieId = Long.parseLong(line.get("movie_id"));
                            r.addRating(movieId.toString(), Double.parseDouble(line.get("rating")));
                        }
                    });
        }


        //System.out.println("Total raters in the file: " + ratersList.stream().count());
        //moviesList.stream().forEach(System.out::println);

        return ratersList;
    }

}

/*
Specifically for this assignment you will write the following methods in a new class named FirstRatings:

Write a method named loadMovies that has one parameter, a String named filename. This method should process every record
from the CSV file whose name is filename, a file of movie information, and return an ArrayList of type Movie with all of
the movie data from the file.

Write a void method named testLoadMovies that should do several things.

    Call the method loadMovies on the file ratedmovies_short.csv and store the result in an ArrayList local variable .
    Print the number of movies, and print each movie. You should see there are five movies in this file, which are all
    shown above. After this works you should comment out the printing of the movies. If you run your program on the file
    ratedmoviesfull.csv, you should see there are 3143 movies in the file.


In the FirstRatings class, write a method named loadRaters that has one parameter named filename. This method should
process every record from the CSV file whose name is filename, a file of raters and their ratings, and return an
ArrayList of type Rater with all the rater data from the file.

Write a void method named testLoadRaters that should do several things.

    Call the method loadRaters on the file ratings_short.csv and store the result in a local ArrayList variable. Print
    the total number of raters. Then for each rater, print the rater’s ID and the number of ratings they did on one line,
    followed by each rating (both the movie ID and the rating given) on a separate line. If you run your program on the
    file ratings_short.csv you will see there are five raters. After it looks like it works, you may want to comment out
    the printing of each rater and their ratings. If you run your program on the file ratings.csv, you should get 1048
    raters.
*/