package ru.noname070.lab3.actions;

import java.util.Random;

public enum StifleActions {
    SONGS,
    PUZZLES,
    PROVERBS;

    private static Random rnd = new Random();

    public static StifleActions getRandomAction()  {
        StifleActions[] actions = values();
        return actions[rnd.nextInt(actions.length)];
    }
}
