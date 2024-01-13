package ru.noname070.lab3.time;


public enum Time {
    MORNING(1000),
    NOON(6000),
    EVENING(9000),
    DAYEND(11000),
    NIGHT(13000),
    MIDNIGHT(18000),
    FULLDAY(24000);
    // source: https://minecraft.fandom.com/wiki/Commands/time

    private int value;

    Time(int x) {
        this.value = x;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(Time obj) {
        return obj.getValue() == this.getValue();
        // return obj.getClass() == this.getClass() ? ((Time) obj).getValue() == this.getValue() : (int) obj == this.getValue();
    }


}