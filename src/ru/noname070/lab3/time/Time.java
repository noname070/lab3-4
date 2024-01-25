package ru.noname070.lab3.time;

public enum Time {
    MORNING(1000),
    // NOON(6000),
    EVENING(9000),
    DAYEND(11000),
    // NIGHT(13000),
    // MIDNIGHT(18000),
    FULL_DAY(24000);
    // source: https://minecraft.fandom.com/wiki/Commands/time

    private final int value;

    Time(int x) {
        this.value = x;
    }

    public int getValue() {
        return value;
    }

}