package com.codecool.data;

import java.util.Random;

public class RandomGenerator {
    private Random random;

    public int generateRandomNumber(int max) {
        random = new Random();
        return random.nextInt(max);
    }
}
