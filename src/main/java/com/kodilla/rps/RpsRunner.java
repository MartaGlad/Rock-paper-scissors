package com.kodilla.rps;

import static com.kodilla.rps.UserDialogs.*;
import static com.kodilla.rps.GameState.*;

public class RpsRunner {

    public static void main(String[] args) {
        boolean end = false;
        int userMove, computerMove;
        Result result;
        char answer;
        MoveType[] values = MoveType.values();

        String username = getUsername();
        int numberOfRounds = getNumberOfRounds();
        int winsToEnd = getNumberOfWonRoundsToEnd();
        checkRounds(numberOfRounds, winsToEnd);

        showInstructions();

        while (!end) {
            userMove = getInput();
            if (userMove == -1) {
                System.out.println("Game exited by user.");
                break;
            }
            computerMove = ComputerLogic.makeMove();
            System.out.println(username + " chose: " + values[userMove - 1] +
                    ", computer chose: " + values[computerMove - 1]);
            result = ResultCounter.computeResult(userMove, computerMove);
            System.out.print("Round result: ");
            if (result == Result.DRAW) {
                drawCounter++;
                System.out.println("draw.");
            }
            else if (result == Result.COMPUTER_WON) {
                computerWonCounter++;
                System.out.println("computer won.");
            }
            else if (result == Result.USER_WON) {
                userWonCounter++;
                System.out.println(username + " won.");
            }
            roundCounter++;

            showSummary(username, userWonCounter, computerWonCounter, drawCounter);

            if((userWonCounter == winsToEnd) || (computerWonCounter == winsToEnd)) {
                showSummary(username, userWonCounter, computerWonCounter, drawCounter);
                answer = endGameOrStartNewOne();
                if (answer == 'x') {
                    end = true;
                }
                else {
                    numberOfRounds = getNumberOfRounds();
                    winsToEnd = getNumberOfWonRoundsToEnd();
                    checkRounds(numberOfRounds, winsToEnd);
                    resetGame();
                }
            }
            else if (roundCounter == numberOfRounds) {
                System.out.println("Maximum number of rounds reached.\n");
                answer = endGameOrStartNewOne();
                if (answer == 'x') {
                    end = true;
                }
                else {
                    numberOfRounds = getNumberOfRounds();
                    winsToEnd = getNumberOfWonRoundsToEnd();
                    checkRounds(numberOfRounds, winsToEnd);
                    resetGame();
                }
            }
        }
    }
}
