import java.util.*;

public class LeaderboardService {

        public static void displayLeaderboard(List<QuizAttempt> attempts) {

                // Sort using Comparator
                Collections.sort(attempts, new ScoreComparator());

                System.out.println("\n===== FINAL LEADERBOARD =====");

                int rank = 1;
                for (QuizAttempt a : attempts) {
                        System.out.println(rank + ". " +
                                        a.getStudent().getName() +
                                        " Score: " + a.getScore());
                        rank++;
                }

                // Topper
                System.out.println("\n===== TOPPER =====");

                attempts.stream()
                                .max(Comparator.comparingDouble(QuizAttempt::getScore))
                                .ifPresent(t -> System.out.println(
                                                "Topper: " + t.getStudent().getName()));
        }
}