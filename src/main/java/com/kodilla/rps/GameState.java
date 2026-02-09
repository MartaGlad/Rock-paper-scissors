package com.kodilla.rps;

public class GameState {
   static int userWonCounter;
   static int computerWonCounter;
   static int drawCounter;
   static int roundCounter;

    static void resetGame() {
        userWonCounter = 0;
        computerWonCounter = 0;
        drawCounter = 0;
        roundCounter = 0;
    }

}
