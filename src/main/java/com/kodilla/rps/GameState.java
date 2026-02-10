package com.kodilla.rps;

public class GameState {

   static int userWinsCounter;
   static int computerWinsCounter;
   static int drawsCounter;
   static int roundsCounter;

   static void resetGame() {
       userWinsCounter = 0;
       computerWinsCounter = 0;
       drawsCounter = 0;
       roundsCounter = 0;
    }

}
