package com.kodilla.rps;

import java.util.Scanner;

public class UserDialogs {

    private static final Scanner sc = new Scanner(System.in);

    private static final int EXIT = -1;
    private static final int RESTART = 0;
    private static final int MAX_MOVE = 3;

    private static int getRightNumber() {
        int numberOfRounds;
        while (true) {
            String choice = sc.nextLine();
            try {
                numberOfRounds = Integer.parseInt(choice.trim());
            } catch (NumberFormatException e) {
                System.out.println("It's not a number! Try again.");
                continue;
            }
            if (numberOfRounds < 1) {
                System.out.println("Choose number at least 1!");
                continue;
            }
            break;
        }
        return numberOfRounds;
    }


    private static char getRightChoice() {
        String choice;
        while (true) {
            choice = sc.nextLine();
            if (!choice.trim().equalsIgnoreCase("n")
                    && !choice.trim().equalsIgnoreCase("x")) {
                System.out.println("Choose X or N");
                continue;
            }
            break;
        }
      return choice.toLowerCase().charAt(0);
    }


    static String getUsername() {
        System.out.print("\nWelcome to Rock-Paper-Scissors game!\n\nPlease enter your username: ");
        return sc.nextLine();
    }


    static int getNumberOfRounds() {
        System.out.println("How many rounds would you like to play?");
        return getRightNumber();
    }


    static int getNumberOfWinsToEnd() {
        System.out.println("How many wins end the game?");
        return getRightNumber();
    }


    static int getCheckedNumberOfWinsToEnd(int numberOfRounds, int numberOfWinsToEnd) {
        while (numberOfWinsToEnd > numberOfRounds) {
                System.out.println("Number of wins must be smaller than or equal to the total number of rounds.");
                System.out.print("Give the right number: ");
                numberOfWinsToEnd = getRightNumber();
            }

        return numberOfWinsToEnd;
    }


    static void showInstructions() {
        System.out.println("""
                Instructions:
                Key 1 - Rock
                Key 2 - Paper
                Key 3 - Scissors
                x - End of the game
                n - Play again
                """);
    }


    static int getInput() {
        System.out.println("Enter your move: ");
        int move;

        while (true) {
            String choice = sc.nextLine().trim();
            if (choice.equalsIgnoreCase("x")) {
                return EXIT;
            }
            if (choice.equalsIgnoreCase("n")) {
                return RESTART;
            }
            try {
                move = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("It's not a number! Try again.");
                continue;
            }
            if (move < 1 || move > MAX_MOVE) {
                System.out.println("Choose 1, 2 or 3!");
                continue;
            }
            break;
        }
        return move;
    }


    static char endGameOrStartNewOne() {
        System.out.println("If you want to end the game press X.");
        System.out.println("If you want to start the new game press N.");
        return getRightChoice();
    }


    public static void showSummary(String username, int userWinCounter, int computerWinCounter, int drawCounter) {
        System.out.println("-------------------------------------------");
        System.out.println("Number of rounds won by " + username + ": " + userWinCounter);
        System.out.println("Number of rounds won by computer: " + computerWinCounter);
        System.out.println("Number of draws: " + drawCounter);
        System.out.println("-------------------------------------------");
    }
}
