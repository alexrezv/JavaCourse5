package Week3.model.impl;

import Week1.Rating;
import Week3.model.Rater;

import java.util.ArrayList;
import java.util.HashMap;

public class EfficientRater implements Rater {
    private String id;
    private HashMap<String, Rating> myRatings;

    @Override
    public void addRating(String item, double rating) {
        myRatings.putIfAbsent(item, new Rating(item, rating));
    }

    @Override
    public boolean hasRating(String item) {
        return myRatings.containsKey(item);
    }

    @Override
    public double getRating(String item) {
        try {
            return myRatings.entrySet().stream()
                    .filter(e -> e.getKey().equals(item)).findFirst()
                    .orElse(null).getValue().getValue();
        } catch (NullPointerException e) {
            return -1;
        }
    }

    @Override
    public int numRatings() {
        return myRatings.values().size();
    }

    @Override
    public ArrayList<String> getItemsRated() {
        return new ArrayList<>(myRatings.keySet());
    }
}
