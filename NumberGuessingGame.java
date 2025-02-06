import java.util.Random;
import java.util.Scanner;

// Main class for the Number Guessing Game
public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create Scanner for user input and Random for generating a random number
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define the range for the random number
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Set the maximum number of attempts and initialize attempt counter
        int maxAttempts = 5;
        int attempts = 0;
        boolean guessedCorrectly = false; // Track if the user guessed correctly

        // Display game instructions
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);
        System.out.println("You have " + maxAttempts + " attempts.");

        // Main game loop that continues until the user runs out of attempts
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");

            // Validate input: ensure the user enters a number
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int userGuess = scanner.nextInt(); // Store user's guess

            // Check if guess is outside the allowed range before counting as an attempt
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("⚠ Your guess is out of range! Try a number between " + lowerBound + " and " + upperBound);
                continue; // Skip incrementing attempts and restart loop
            }

            attempts++; // Increment attempt counter only if the guess is valid

            // Check if the user guessed correctly
            if (userGuess == randomNumber) {
                guessedCorrectly = true;
                System.out.println("🎉 Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break; // Exit loop as the game has been won
            }
            // Provide feedback if guess is incorrect
            else if (userGuess > randomNumber) {
                System.out.println("⬆ Too High! Try again.");
            } else {
                System.out.println("⬇ Too Low! Try again.");
            }

            // Display the number of remaining attempts
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        // If the user didn't guess correctly, reveal the correct number
        if (!guessedCorrectly) {
            System.out.println("❌ Game Over! The correct number was: " + randomNumber);
        }

        // Ask the user if they want to play again
        System.out.print("Would you like to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();

        // Restart the game if the user chooses to play again
        if (playAgain.equals("yes")) {
            main(args); // Call main method recursively to restart the game
        } else {
            System.out.println("Thanks for playing! Goodbye."); // Exit message
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
