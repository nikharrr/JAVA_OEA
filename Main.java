import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Phase 1: Create Quiz
        Quiz quiz = QuizBuilder.createQuiz(sc);

        // Phase 2: Conduct Quiz
        List<QuizAttempt> attempts = QuizService.conductQuiz(quiz, sc);

        // Phase 3: Show Leaderboard
        LeaderboardService.displayLeaderboard(attempts);

        sc.close();
    }
}