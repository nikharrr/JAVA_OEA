import java.util.*;

public class QuizService {

    public static List<QuizAttempt> conductQuiz(Quiz quiz, Scanner sc) {

        List<QuizAttempt> attempts = new ArrayList<>();

        System.out.print("\nEnter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\n===== STUDENT " + i + " =====");

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();

            Student student = new Student(id, name, branch);
            QuizAttempt attempt = new QuizAttempt(student, quiz);

            System.out.println("\nStarting Quiz for " + name);

            for (Question q : quiz.getQuestions()) {

                System.out.println("\nQ" + q.getId() + ": " + q.getText());

                List<String> opts = q.getOptions();
                for (int j = 0; j < opts.size(); j++) {
                    System.out.println((j + 1) + ". " + opts.get(j));
                }

                int choice;
                while (true) {
                    System.out.print("Enter answer (1-4): ");
                    choice = sc.nextInt();

                    if (choice >= 1 && choice <= 4) break;
                    System.out.println("Invalid input. Try again.");
                }

                attempt.submitAnswer(q, choice);
            }

            attempt.evaluateScore();
            attempts.add(attempt);

            System.out.println(name + "'s Score: " +
                    attempt.getScore() + "/" + quiz.getTotalQuestions());
        }

        return attempts;
    }
}