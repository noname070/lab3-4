package ru.noname070.lab3.locations;

import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.time.CurrentTimeContainer;
import ru.noname070.lab3.time.Time;

import java.lang.Math;

public class Location extends Entity.TimeSlaveEntity implements ILocation {
    private String name;
    private CurrentTimeContainer currentTime;
    private double visibility = 1.0;
    private double visibility_bias = 0;

    public Location(String name, CurrentTimeContainer currentTime) {
        this.name = name;
        this.currentTime = currentTime;
    }

    public Location(String name, CurrentTimeContainer currentTime, double visibility_bias) {
        this.name = name;
        this.currentTime = currentTime;
        this.visibility_bias = visibility_bias;
    }

    public String getName() {
        return name;
    }

    public void setBias(double new_bias) {
        this.visibility_bias = new_bias;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() ? this.name == ((Location)obj).name : false;
    }

    @Override
    public void timeUpdater(CurrentTimeContainer currentTime) {
        this.currentTime = currentTime;
        this.visibility = Math.min(1, -1 * Math.tanh(currentTime.getCurrentTime()/(24000) * 3.5 - 3) * .5 + .6) + visibility_bias;
    }

} 