import Week2.MovieRunnerAverage;

public class App {
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        MovieRunnerAverage.printAverageRatings();
    }

    String getGreeting() {
        return "\n=== Course 5 Week 2 ===\n";
    }
}

