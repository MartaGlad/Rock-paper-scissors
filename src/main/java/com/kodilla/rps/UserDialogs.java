package com.kodilla.rps;

import java.util.Scanner;

public class UserDialogs {
    private static final Scanner sc = new Scanner(System.in);

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
        System.out.print("\nWelcome to Rock-Papier-Scissors game!\n\nPlease enter your username: ");
        return sc.nextLine();
    }

    static int getNumberOfRounds() {
        System.out.println("How many rounds would you like to play?");
        return getRightNumber();
    }


    static int getNumberOfWonRoundsToEnd() {
        System.out.println("How many wins ends the game?");
        return getRightNumber();
    }


    static void checkRounds(int numberOfRounds, int numberOfWonRoundsToEnd) {
        while (true) {
            if (numberOfWonRoundsToEnd > numberOfRounds) {
                System.out.println("Number of wins must be even or smaller than the total number of rounds.");
                System.out.print("Give the right number: ");
                numberOfWonRoundsToEnd = getRightNumber();
                continue;
            }
            break;
        }
    }


    static void showInstructions() {
        System.out.println("""
                Key 1 - Rock\s
                Key 2 - Paper\s
                Key 3 - Scissors
                x - End of the game\s
                n - Play again
                """);
    }



    static int getInput() {
        System.out.println("Enter your move: ");
        int move;

        while (true) {
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("x")) {
                return -1;
            }
            try {
                move = Integer.parseInt(choice.trim());
            } catch (NumberFormatException e) {
                System.out.println("It's not a number! Try again.");
                continue;
            }
            if (move < 1 || move > 3){
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


    public static void showSummary(String username, int userWonCounter, int computerWonCounter, int drawCounter) {
        System.out.println("-------------------------------------------");
        System.out.println("Number of rounds won by " + username + ": " + userWonCounter);
        System.out.println("Number of rounds won by computer: " + computerWonCounter);
        System.out.println("Number of draws: " + drawCounter);
        System.out.println("-------------------------------------------");
    }
}
