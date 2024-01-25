package ru.noname070.lab3.locations;

import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.time.ITimeContainer;

import java.lang.Math;

public class Location extends Entity.TimeSlaveEntity implements ILocation {
    private double visibility = 1.0;
    private double visibility_bias = 0;
    private double rayTracingBias = 0;

    private ILocation rayTraycingLocation;

    @Override
    public void setRayTracingBias(double v) {
        rayTracingBias = v;
    }

    public Location(String name, ITimeContainer currentTime) {
        super(name, currentTime);
    }

    public Location(String name, ITimeContainer currentTime, double visibility_bias) {
        super(name, currentTime);

        this.visibility_bias = visibility_bias;
    }

    @Override
    public double getVisibility() {return visibility;}

    @Override
    public void setBias(double new_bias) {
        this.visibility_bias = new_bias;
    }

    @Override
    public void setVisibility(double new_visibility) {
        this.visibility = new_visibility;
    }

    // @Override
    public void setRayTraycing(ILocation targetLocation) {
        rayTraycingLocation = targetLocation;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     return this.getClass() == obj.getClass() ? this.name == ((Location)obj).name : false;
    // }

    public void timeUpdater(ITimeContainer currentTime) {
        this.setCurrentTime(currentTime);

        this.visibility = Math.min(1, -1 * Math.tanh(
            currentTime.getCurrentTime()/(24000) * 3.5 - 3) * .5 + .6
        ) + visibility_bias + rayTracingBias;
        this.rayTracingBias = 0;

        if (rayTraycingLocation != null) {
            rayTraycingLocation.setRayTracingBias(this.visibility * .4);
        }

    }




} 