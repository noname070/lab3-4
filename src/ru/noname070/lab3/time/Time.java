package ru.noname070.lab3.time;

public enum Time {
    MORNING(1000),
    NOON(6000),
    EVENING(9000),
    DAYEND(11000),
    NIGHT(13000),
    MIDNIGHT(18000);
    // source: https://minecraft.fandom.com/wiki/Commands/time

    private int value;

    Time(int x) {
        this.value = x;
    }

    public int getValue() {
        return value;
    }

    /*
    thx to stackoverfow <3
     https://stackoverflow.com/questions/15436721/get-index-of-enum-from-string
    */

    public static int getTimeDelta(Time t1, Time t2) {
        int t1value = t1.getValue();
        int t2value = t2.getValue();
        return Math.abs(t2value - t1value);
    }

}