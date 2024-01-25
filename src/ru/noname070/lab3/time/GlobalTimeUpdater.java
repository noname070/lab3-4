package ru.noname070.lab3.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import ru.noname070.lab3.entity.ITimeSlaveEntity;

public class GlobalTimeUpdater implements ITimeUpdater {
    private final CurrentTimeContainer currentTime;
    private final ArrayList<ITimeSlaveEntity> objects2update = new ArrayList<ITimeSlaveEntity>();

    public GlobalTimeUpdater(CurrentTimeContainer currentTime, ITimeSlaveEntity... objects2update) {
        this.currentTime = currentTime;
        Collections.addAll(this.objects2update, objects2update);
    }

    @Override
    public void timeStep() {
        for (ITimeSlaveEntity slave : objects2update) {
            slave.timeUpdater(currentTime);
        }
    }

    @Override
    public void addObjects2Update(ITimeSlaveEntity... anyObjects) {
        this.objects2update.addAll(Arrays.asList(anyObjects));
    }

}
