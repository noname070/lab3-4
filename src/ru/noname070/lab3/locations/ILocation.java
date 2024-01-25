package ru.noname070.lab3.locations;


public interface ILocation {

    void setRayTracingBias(double v);

    String getName();

    double getVisibility();

    void setBias(double new_bias);

    void setVisibility(double new_visibility);

    void setRayTraycing(ILocation targetLocation);


}