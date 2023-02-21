package com.example.mainapp.utility;

import java.util.Random;

public class Utilities {
    private Utilities() {
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
