package Week1;

import lombok.Getter;

import java.util.ArrayList;

/**
 * Write a description of class Rater here.
 *
 * @author AlexRezv
 * @version 18.06.2018
 */

@Getter
public class Rater {
    private String id;
    private ArrayList<Rating> myRatings;

    public Rater(String id) {
        this.id = id;
        myRatings = new ArrayList<>();
    }

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item, rating));
    }

    public boolean hasRating(String item) {
        for (Rating myRating : myRatings) {
            if (myRating.getItem().equals(item)) {
                return true;
            }
        }

        return false;
    }

    public double getRating(String item) {
        for (int k = 0; k < myRatings.size(); k++) {
            if (myRatings.get(k).getItem().equals(item)) {
                return myRatings.get(k).getValue();
            }
        }

        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for (int k = 0; k < myRatings.size(); k++) {
            list.add(myRatings.get(k).getItem());
        }

        return list;
    }
}
