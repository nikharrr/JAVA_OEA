import java.util.Comparator;

public class ScoreComparator implements Comparator<QuizAttempt> {

    @Override
    public int compare(QuizAttempt a1, QuizAttempt a2) {

        int scoreCompare = Double.compare(a2.getScore(), a1.getScore());

        if (scoreCompare != 0) {
            return scoreCompare;
        }

        // Tie-breaker → sort by name
        return a1.getStudent().getName()
                .compareToIgnoreCase(a2.getStudent().getName());
    }
}