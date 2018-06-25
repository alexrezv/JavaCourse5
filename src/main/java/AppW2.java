import Week2.MovieRunnerAverage;

public class AppW2 {
    public static void main(String[] args) {
        System.out.println(new AppW2().getGreeting());
        MovieRunnerAverage.printAverageRatings();
        MovieRunnerAverage.getAverageRatingOneMovie();
    }

    String getGreeting() {
        return "\n=== Course 5 Week 2 ===\n";
    }
}

