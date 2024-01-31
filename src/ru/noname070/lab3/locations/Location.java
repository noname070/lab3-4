package ru.noname070.lab3.locations;

import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.time.ITimeContainer;

import java.lang.Math;
import java.util.Objects;

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
    public void setBias(double new_bias) {
        this.visibility_bias = new_bias;
    }

    public void timeUpdater(ITimeContainer currentTime) {
        this.setCurrentTime(currentTime);

        this.visibility = Math.min(1, -1 * Math.tanh(
                ((double) currentTime.getCurrentTime() / (24000)) * 3.5 - 3) * .5 + .6) + visibility_bias
                + rayTracingBias;
        this.rayTracingBias = 0;

        if (rayTraycingLocation != null) {
            rayTraycingLocation.setRayTracingBias(this.visibility * .4);
        }

    }

    @Override
    public int hashCode() {
        return (Double.hashCode(Math.min(0.001, this.visibility) * Math.min(0.001, this.visibility_bias)
                * Math.min(0.001, this.rayTracingBias))) * this.getName().hashCode()
                * this.getCurrentTime().getCurrentTime();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;

        Location othertLocation = (Location) obj;
        if (!Objects.equals(this.getName(), othertLocation.getName()))
            return false;
        if (this.rayTracingBias != othertLocation.rayTracingBias)
            return false;
        if (this.rayTraycingLocation != othertLocation.rayTraycingLocation)
            return false;
        if (this.visibility != othertLocation.visibility)
            return false;
        return this.visibility_bias == othertLocation.visibility_bias;
    }

}