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
    private double rayTracingBias = 0;

    public void setRayTracingBias(double v) {
        rayTracingBias = v;
    }


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

    public double getVisibility() {return visibility;}


    public void setBias(double new_bias) {
        this.visibility_bias = new_bias;
    }

    public void setVisibility(double new_visibility) {
        this.visibility = new_visibility;
    }

    Location rayTraycingLocation;
    public void  setRayTraycing(Location targetLocation) {
        rayTraycingLocation = targetLocation;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() ? this.name == ((Location)obj).name : false;
    }

    @Override
    public void timeUpdater(CurrentTimeContainer currentTime) {
        this.currentTime = currentTime;
        this.visibility = Math.min(1, -1 * Math.tanh(
            currentTime.getCurrentTime()/(24000) * 3.5 - 3) * .5 + .6
        ) + visibility_bias + rayTracingBias;
        this.rayTracingBias = 0;

        if (rayTraycingLocation != null) {
            rayTraycingLocation.setRayTracingBias(this.visibility * .4);
        }

    }

} 