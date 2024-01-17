package ru.noname070.lab3.time;

public class CurrentTimeContainer {
    private int time;

    public CurrentTimeContainer(int time) {
        this.time = time;
    }

    public int getCurrentTime() {return time;}
    public void setCurrentTime(int time) {this.time = time;}
    public void addToCurrentTime(int time) {this.time += time;}
}
