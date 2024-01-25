package ru.noname070.lab3.stiffleActions;

import java.util.Random;

public enum StiffleActions {
    SONGS("singing songs to stifle hunger"),
    PUZZLES("are making deals to stifle hunger"),
    PROVERBS("reminded of the proverbs to stifle hunger");

    private String name;
    StiffleActions(String name) {
        this.name = name;
    }

    public String actionDescription() {
        return this.name;
    }

    private static Random rnd = new Random();
    public static StiffleActions getRandomAction()  {
        StiffleActions[] actions = values();
        return actions[rnd.nextInt(actions.length)];
    }
}