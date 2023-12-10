package ru.noname070.lab3.stiffleActions;

import java.util.Random;

public enum StiffleActions {
    SONGS,
    PUZZLES,
    PROVERBS;

    private static Random rnd = new Random();
    
    public static String doAction(StiffleActions action) {
        switch (action) {
            case SONGS:
                return "singing songs to stifle hunger";
            
            case PUZZLES:
                return "are making deals to stifle hunger";

            case PROVERBS:
                return "reminded of the proverbs to stifle hunger";
            
            default:
                break;
        
        }
        return "";
    }

    public static StiffleActions getRandomAction()  {
        StiffleActions[] actions = values();
        return actions[rnd.nextInt(actions.length)];
    }
}