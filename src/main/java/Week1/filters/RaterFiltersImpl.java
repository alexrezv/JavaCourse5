package Week1.filters;

import Week1.Rater;
import Week1.Rating;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaterFiltersImpl implements RaterFilters {

    //Add code to find the number of ratings for a particular rater you specify in your code. For example, if you run
    //this code on the rater whose rater_id is 2 for the file ratings_short.csv, you will see they have three ratings.
    public long howManyRatingsForRaterById(ArrayList<Rater> raters, String id) {
        return (long) raters.stream().filter(r -> r.getId().equals(id)).findFirst().get().getMyRatings().size();
    }

    //Add code to find the maximum number of ratings by any rater.
    public long maxRatingsByAnyRater(ArrayList<Rater> raters) {
        return raters.stream().collect(Collectors.toMap(Rater::getId, v -> (long) v.getMyRatings().size()))
                .entrySet().stream().map(Map.Entry::getValue).max(Comparator.naturalOrder()).orElse((long) 666);
    }

    // Determine how many raters have this maximum number of
    //ratings and who those raters are. If you run this code on the file ratings_short.csv, you will see rater 2 has
    //three ratings, the maximum number of ratings of all the raters, and that there is only one rater with three ratings.
    public String getRatersWithNumOfRatings(ArrayList<Rater> ratersList, int ratingsNum) {
        List<String> raters = ratersList.stream()
                .collect(Collectors.toMap(Rater::getId, v -> (long) v.getMyRatings().size()))
                .entrySet().stream().filter(e -> e.getValue() == ratingsNum)
                .collect(Collectors.toMap(o -> o.getKey(), ignore -> 0))
                .keySet().stream().collect(Collectors.toList());
        return raters.toString();
    }

    //Add code to find the number of ratings a particular movie has. If you run this code on the file ratings_short.csv
    //for the movie “1798709”, you will see it was rated by four raters.
    public long howManyRatingsForAMovieById(ArrayList<Rater> raterList, String movieId) {
        List<Rating> allRatingsList = new ArrayList<>();
        for (Rater rater : raterList) {
            List<Rating> ratersRatingsList = rater.getMyRatings();
            for (Rating rating : ratersRatingsList) {
                allRatingsList.add(rating);
            }
        }
        return allRatingsList.stream().filter(r -> r.getItem().equals(movieId)).count();
    }

    //Add code to determine how many different movies have been rated by all these raters. If you run this code on the
    //file ratings_short.csv, you will see there were four movies rated.
    public long howManyMoviesHaveBeenRated(ArrayList<Rater> ratersList) {
        ArrayList<ArrayList<String>> listOfListsOfRatedMovies =
                ratersList.stream().map(Rater::getItemsRated).collect(Collectors.toCollection(ArrayList::new));
        List<String> allRatedMovies = new ArrayList<>();
        for (ArrayList<String> innerList : listOfListsOfRatedMovies) {
            allRatedMovies.addAll(innerList);
        }

        return allRatedMovies.stream().distinct().count();
    }


}