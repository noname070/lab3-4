package ru.noname070.lab3.time;

import ru.noname070.lab3.entity.Entity.TimeSlaveEntity;

public interface ITimeUpdater {

    void timeStep();

    void addObjects2Update(TimeSlaveEntity... anyObjects);

}