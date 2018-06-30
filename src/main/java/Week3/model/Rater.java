package Week3.model;

import java.util.ArrayList;

public interface Rater {
    void addRating(String item, double rating);

    boolean hasRating(String item);

    double getRating(String item);

    int numRatings();

    ArrayList<String> getItemsRated();
}
