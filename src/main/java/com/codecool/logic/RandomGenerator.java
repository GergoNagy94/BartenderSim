package com.codecool.logic;

import java.util.Random;

public class RandomGenerator {
    private Random random;

    public int generateRandomNumber(int max) {
        random = new Random();
        int valid = 0;
        while (valid == 0) {
            valid = random.nextInt(max);
        }
        return valid;
    }
}
