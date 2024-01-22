package ru.noname070.lab3.time;

public class CurrentTimeContainer implements ITimeContainer {
    private int time;

    public CurrentTimeContainer(int time) {
        this.time = time;
    }

    @Override
    public int getCurrentTime() {return time;}

    @Override
    public void setCurrentTime(int time) {this.time = time;}
    
    @Override
    public void addToCurrentTime(int time) {this.time += time;}
}
