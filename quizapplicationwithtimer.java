import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class QuizApp {
    private List<QuizQuestion> questions;
    private int score;
    private Scanner scanner;

    public QuizApp(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You will have 10 seconds to answer each question.\n");

        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char) ('A' + j) + ". " + options.get(j));
            }
            System.out.print("Your answer: ");

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up!");
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                }
            };

            timer.schedule(task, 10000); // 10 seconds timer

            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));
            timer.cancel(); // Cancel the timer

            int userOptionIndex = userAnswer - 'A';
            int correctOptionIndex = currentQuestion.getCorrectOptionIndex();

            if (userOptionIndex == correctOptionIndex) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + (char) ('A' + correctOptionIndex));
            }
            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        // Create quiz questions
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("London", "Paris", "Berlin", "Rome"), 1));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?", Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"), 1));
        questions.add(new QuizQuestion("Who wrote 'To Kill a Mockingbird'?", Arrays.asList("Harper Lee", "Mark Twain", "Charles Dickens", "J.K. Rowling"), 0));
        questions.add(new QuizQuestion("What is the chemical symbol for water?", Arrays.asList("H2O", "CO2", "N2O", "O2"), 0));
        questions.add(new QuizQuestion("What is the largest mammal in the world?", Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 1));

        QuizApp quizApp = new QuizApp(questions);
        quizApp.startQuiz();
    }
}
