package com.kodilla.rps;

import java.util.Random;

public class ComputerLogic {

    private static final Random rand = new Random();

    public static int makeMove() {
        return rand.nextInt(3) + 1;

    }
}
