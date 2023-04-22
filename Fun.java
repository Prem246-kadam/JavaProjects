import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // generate random number between 1 and 100

        int guess;
        int numGuesses = 0;
        boolean hasWon = false;

        System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");
        
        while (numGuesses < 5) {
            System.out.println("Guess #" + (numGuesses + 1) + ": ");
            guess = scanner.nextInt();
            numGuesses++;

            if (guess == secretNumber) {
                hasWon = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }
        }

        if (hasWon) {
            System.out.println("Congratulations, you guessed the number in " + numGuesses + " guesses!");
        } else {
            System.out.println("Sorry, you didn't guess the number. The number was " + secretNumber);
        }
    }
}
