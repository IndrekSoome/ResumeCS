import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
	/**
	 * A program that lets the user play Rock Paper Scissors according to predetermined rules
	 * Not acceptable user inputs are handled properly and error message will be printed
	 * 
	 * @author Indrek Soome
	 * @class Object Oriented Programming SP24-CPSC-24500-001
	 * Assignment 3: Rock Paper Scissors
	 * @date: February 23, 2024
	 * 
	 * @param userChoice, int, user's pick for the game
	 * @param computerChoice, int, computer's choice for the game
	 * @precondition user choice is integer between 1 and 3
	 * @postcondition: the program announces the winner and asks if user wants to play again
	 */
	
	// This method displays the required hello message to the user and simply explains how the game works
    public static void displayGreetingAndRules() {
        System.out.println("Hello and welcome to Rock, Paper, Scissors!\n");
        System.out.println("The rules are simple:\n1. Rock beats Scissors\n2. Scissors beats Paper\n3. Paper beats Rock\n");
    }
    // Method to get a valid input (1,3) from the user. Misclicks are handled and error message is displayed if needed.
    public static int gettingUserChoice() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your choice (1 = Rock, 2 = Paper, and 3 = Scissors): ");
                int userChoice = sc.nextInt();

                if (userChoice >= 1 && userChoice <= 3) {
                    return userChoice;
                } 
            } catch (Exception e) {
                System.out.println("Please enter a valid number from 1 to 3.");
                sc.nextLine(); // Consume the input
            }
        }
    }
    // Method that creates and returns a random number 1 to 3
    public static int gettingComputerChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
    // Method that prints out user and computer choices 
    public static void displayBothChoices(int userChoice, int computerChoice) {
        System.out.println("\nYour choice: " + getChoiceName(userChoice));
        System.out.println("Computer choice: " + getChoiceName(computerChoice)+"\n");
    }
    // Method that "changes" numbers to corresponding definitions (Rock, Paper, and Scissors)
    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Rock"; // If 1, return Rock etc.
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }
    // This method determines the winner based on the rules that were given by the Assignment 3
    public static String determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie! Let's play again."; // User chose the same number as computer
            
        }

        if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
            return "Congratulations! You win!"; // User beat the computer based on the rules
        }

        return "Computer wins. Better luck next time."; // Otherwise computer won
    }

    // Method to use other methods to put together 
    public static void playRockPaperScissors() {
    	displayGreetingAndRules();

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int userChoice = gettingUserChoice();
                int computerChoice = gettingComputerChoice();

                displayBothChoices(userChoice, computerChoice);

                String result = determineWinner(userChoice, computerChoice);
                System.out.println(result);

                System.out.print("Do you want to play again? (Y/y for Yes, any other key for No): ");
                String playAgain = sc.next();

                if (!playAgain.toLowerCase().equals("y")) {
                    System.out.println("It was nice to play with you, thank you and goodbye!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: Something went wrong.");
                sc.nextLine(); // Consume the input (solves infinite loop)
            }
        }
    }
    // Main method takes playRockPaperScissors(); to run the whole program
    public static void main(String[] args) {
        try {
        	playRockPaperScissors();
        } catch (Exception e) {
        	System.out.println("Hmm what's happening, try again.");
        }
        	
        
    }
}