package com.kodilla.rps;

public class ResultCounter {

    public static Result computeResult(int userMove, int computerMove) {
        if (userMove == computerMove) {
            return Result.DRAW;
        }
        if ((userMove == 1 && computerMove == 2)
                || (userMove == 2 && computerMove == 3)
                || (userMove == 3 && computerMove == 1)) {
            return Result.COMPUTER_WIN;
        }

        return Result.USER_WIN;

    }
}


