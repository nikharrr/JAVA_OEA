import java.util.*;

public class QuizBuilder {

    public static Quiz createQuiz(Scanner sc) {

        System.out.println("===== CREATE QUIZ =====");

        System.out.print("Enter Quiz Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        Quiz quiz = new Quiz(1, title, subject);

        System.out.print("Enter number of questions: ");
        int qCount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= qCount; i++) {

            System.out.println("\n--- Question " + i + " ---");

            System.out.print("Enter question text: ");
            String qText = sc.nextLine();

            List<String> options = new ArrayList<>();

            for (int j = 1; j <= 4; j++) {
                System.out.print("Enter option " + j + ": ");
                options.add(sc.nextLine());
            }

            int correct;
            while (true) {
                System.out.print("Enter correct option (1-4): ");
                correct = sc.nextInt();
                sc.nextLine();

                if (correct >= 1 && correct <= 4) break;
                System.out.println("Invalid input. Try again.");
            }

            quiz.addQuestion(new Question(i, qText, options, correct));
        }

        return quiz;
    }
}