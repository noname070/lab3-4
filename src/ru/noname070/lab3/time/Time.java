package ru.noname070.lab3.time;


public enum Time {
    MORNING(1000),
    // TODO: не испл.
    NOON(6000),
    EVENING(9000),
    DAYEND(11000),

    // TODO: не испл.
    NIGHT(13000),

    // TODO: не испл.
    MIDNIGHT(18000),
    // TODO: CamelCase для констант -> FIRST_SECOND_THIRD

    FULLDAY(24000);
    // source: https://minecraft.fandom.com/wiki/Commands/time

    // TODO: final

    private int value;

    Time(int x) {
        this.value = x;
    }

    public int getValue() {
        return value;
    }

    // TODO: удали, можно сравнить через простое `==`

    public boolean equals(Time obj) {
        return obj.getValue() == this.getValue();
        // return obj.getClass() == this.getClass() ? ((Time) obj).getValue() == this.getValue() : (int) obj == this.getValue();
    }


}