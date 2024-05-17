import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Guess the Number game!");
        
        int rounds = 0;
        int totalAttempts = 0;
        
        while (true) {
            rounds++;
            System.out.println("\nRound " + rounds);
            
            int secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attempts = 0;
            final int maxAttempts = 5;
            
            while (attempts < maxAttempts) {
                attempts++;
                totalAttempts++;
                
                System.out.print("Guess the number (between 1 and 100): ");
                int guess = scanner.nextInt();
                
                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("You've reached the maximum number of attempts. The number was " + secretNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Attempts: " + totalAttempts);
        
        scanner.close();
    }
}
