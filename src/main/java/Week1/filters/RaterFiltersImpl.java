package Week1.filters;

import Week1.Rater;
import Week1.Rating;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaterFiltersImpl implements RaterFilters {

    private ArrayList<Rater> ratersList;

    public RaterFiltersImpl(ArrayList<Rater> ratersList) {
        this.ratersList = ratersList;
    }

    //Add code to find the number of ratings for a particular rater you specify in your code. For example, if you run
    //this code on the rater whose rater_id is 2 for the file ratings_short.csv, you will see they have three ratings.
    public long howManyRatingsByRaterId(String id) {
        return (long) ratersList.stream().filter(r -> r.getId().equals(id)).findFirst().get().getMyRatings().size();
    }

    //Add code to find the maximum number of ratings by any rater.
    public long maxRatingsByAnyRater() {
        return ratersList.stream().collect(Collectors.toMap(Rater::getId, v -> (long) v.getMyRatings().size()))
                .entrySet().stream().map(Map.Entry::getValue).max(Comparator.naturalOrder()).orElse((long) 666);
    }

    // Determine how many raters have this maximum number of
    //ratings and who those raters are. If you run this code on the file ratings_short.csv, you will see rater 2 has
    //three ratings, the maximum number of ratings of all the raters, and that there is only one rater with three ratings.
    public String getRatersWithNumOfRatings(int ratingsNum) {
        List<String> raters = new ArrayList<>(ratersList.stream()
                .collect(Collectors.toMap(Rater::getId, v -> (long) v.getMyRatings().size()))
                .entrySet().stream().filter(e -> e.getValue() == ratingsNum)
                .collect(Collectors.toMap(Map.Entry::getKey, ignore -> 0))
                .keySet());
        return raters.toString();
    }

    //Add code to find the number of ratings a particular movie has. If you run this code on the file ratings_short.csv
    //for the movie “1798709”, you will see it was rated by four raters.
    public long howManyRatingsByMovieId(String movieId) {
        List<Rating> allRatingsList = new ArrayList<>();
        for (Rater rater : ratersList) {
            List<Rating> ratersRatingsList = rater.getMyRatings();
            allRatingsList.addAll(ratersRatingsList);
        }
        return allRatingsList.stream().filter(r -> r.getItem().equals(movieId)).count();
    }

    //Add code to determine how many different movies have been rated by all these raters. If you run this code on the
    //file ratings_short.csv, you will see there were four movies rated.
    public long howManyMoviesHaveBeenRated() {
        ArrayList<ArrayList<String>> listOfListsOfRatedMovies =
                ratersList.stream().map(Rater::getItemsRated).collect(Collectors.toCollection(ArrayList::new));
        List<String> allRatedMovies = new ArrayList<>();
        for (ArrayList<String> innerList : listOfListsOfRatedMovies) {
            allRatedMovies.addAll(innerList);
        }

        return allRatedMovies.stream().distinct().count();
    }

    public long howManyRatersRatedGivenMovie(String movieId) {
        return ratersList.stream().filter(rater -> rater.hasRating(movieId)).count();
    }

    private ArrayList<Double> getAllRatingsByMovieId(String movieId) {
        Map<String, Double> ratersToMovieRating = ratersList.stream().filter(rater -> rater.hasRating(movieId))
                .collect(Collectors.toMap(Rater::getId, v -> v.getRating(movieId)));
        return new ArrayList<>(ratersToMovieRating.values());
    }

    //In the SecondRatings class, write a private helper method named getAverageByID that has two parameters: a String
    // named id representing a movie ID and an integer named minimalRaters. This method returns a double representing
    // the average movie rating for this ID if there are at least minimalRaters ratings. If there are not minimalRaters
    // ratings, then it returns 0.0.
    public double getAverageRatingByMovieID(String movieId, int minimalRaters) {
        double averageRating = 0.0;

        if (howManyRatersRatedGivenMovie(movieId) >= minimalRaters) {
            ArrayList<Double> allRatings = getAllRatingsByMovieId(movieId);
            double sum = 0;
            for (double d : allRatings) {
                sum += d;
            }
            averageRating = sum / allRatings.size();
        }

        return averageRating;
    }

    //In the SecondRatings class, write a public method named ​getAverageRatings​, which has one int parameter named
    // minimalRaters​. This method should find the average rating for every movie that has been rated by at least ​
    // minimalRaters​ raters. Store each such rating in a Rating object in which the movie ID and the average rating are
    // used in creating the Rating object. The method getAverageRatings​ ​should return an ArrayList of all the Rating
    // objects for movies that have at least the minimal number of raters. For example, if minimalRaters​ ​has the value
    // 10, then this method returns rating information (the movie ID and its average rating) for each movie that has at
    // least 10 ratings. You should consider calling the private ​ getAverageByID​ method.
    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> avgRatingsList = new ArrayList<>();

        List<String> movieIdList = new ArrayList<>();

        for (Rater r : ratersList) {
            movieIdList.addAll(r.getItemsRated());
        }
        movieIdList = movieIdList.stream().distinct().collect(Collectors.toList());

        Map<String, Long> moviesToNumRatings = movieIdList.stream()
                .collect(Collectors.toMap(k -> k, this::howManyRatersRatedGivenMovie));

        moviesToNumRatings = moviesToNumRatings.entrySet().stream().filter(e -> e.getValue() >= minimalRaters).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (String movieId : moviesToNumRatings.keySet()) {
            avgRatingsList.add(new Rating(movieId, getAverageRatingByMovieID(movieId, minimalRaters)));
        }

        return avgRatingsList;
    }

    public long countMoviesWithOrMoreRatings(int minRatingsCount) {
        List<String> movieIdList = new ArrayList<>();

        for (Rater r : ratersList) {
            movieIdList.addAll(r.getItemsRated());
        }
        movieIdList = movieIdList.stream().distinct().collect(Collectors.toList());

        Map<String, Long> moviesToNumRatings = movieIdList.stream()
                .collect(Collectors.toMap(k -> k, this::howManyRatersRatedGivenMovie));

        return moviesToNumRatings.entrySet().stream().filter(a -> a.getValue() >= minRatingsCount).count();
    }

}