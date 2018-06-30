import Week3.MovieRunnerWithFilters;

public class AppW3 {
    public static void main(String[] args) {
        System.out.println(new AppW3().getGreeting());
        MovieRunnerWithFilters.printAverageRatings();
    }

    String getGreeting() {
        return "\n=== Course 5 Week 2 ===\n";
    }
}

