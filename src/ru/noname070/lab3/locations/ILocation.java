package ru.noname070.lab3.locations;


public interface ILocation {

    void setRayTracingBias(double v);

    // TODO: не используется
    String getName();

    // TODO: не используется
    double getVisibility();

    void setBias(double new_bias);

    // TODO: не используется
    void setVisibility(double new_visibility);

    // TODO: не используется
    void setRayTraycing(ILocation targetLocation);


}