package com.kodilla.rps;

import static com.kodilla.rps.GameState.*;
import static com.kodilla.rps.UserDialogs.*;

public class RspGame {

    private final String username;

    private int totalRounds;
    private int winsToEnd;

    private boolean end = false;

    private final MoveType[] values = MoveType.values();

    private static final int EXIT = -1;
    private static final int RESTART = 0;
    private static final char EXIT_CHOICE = 'x';


    public RspGame() {
        this.username = getUsername();
        this.totalRounds = getNumberOfRounds();
        this.winsToEnd = getCheckedNumberOfWinsToEnd(totalRounds, getNumberOfWinsToEnd());
    }


    public void start() {

        showInstructions();

        while(!end) {
            playRound();
            checkGameEnd();
        }
    }


    private void playRound() {

        int userMove = getInput();

        if (userMove == EXIT) {
            System.out.println("Game exited by user.");
            end = true;
            return;
        }

        if (userMove == RESTART) {
            System.out.println("We play again.");
            resetGame();
            return;
        }

        int computerMove = ComputerLogic.makeMove();

        System.out.println(username + " chose: " + values[userMove - 1] +
                ", computer chose: " + values[computerMove - 1]);

        Result result = ResultCounter.computeResult(userMove, computerMove);
        handleResult(result);

        roundsCounter++;

        showSummary(username, userWinsCounter, computerWinsCounter, drawsCounter);
    }


    private void handleResult(Result result) {
        System.out.print("Round result: ");
        switch (result) {
            case DRAW -> {
                drawsCounter++;
                System.out.println("draw");
            }
            case COMPUTER_WIN -> {
                computerWinsCounter++;
                System.out.println("computer won");
            }
            case USER_WIN ->  {
                userWinsCounter++;
                System.out.println(username + " won");
            }
        }
    }


    private void checkGameEnd() {
        if ((userWinsCounter == winsToEnd) || (computerWinsCounter == winsToEnd)) {
           restartOrEnd();
        } else if (roundsCounter == totalRounds) {
            System.out.println("Maximum number of rounds reached.\n");
            restartOrEnd();
        }
    }


    private void restartOrEnd() {

        char choice = endGameOrStartNewOne();

        if (choice == EXIT_CHOICE) {
            end = true;
        }
        else {
            totalRounds = getNumberOfRounds();
            winsToEnd = getCheckedNumberOfWinsToEnd(totalRounds, getNumberOfWinsToEnd());
            resetGame();
        }
    }
}





